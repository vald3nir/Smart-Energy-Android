package com.vald3nir.smart_energy.domain.use_cases.persistence

import com.vald3nir.smart_energy.data.dtos.ContractDTO
import com.vald3nir.smart_energy.data.repository.remote.contract.ContractRepository
import com.vald3nir.smart_energy.data.repository.remote.historic.HistoricRepository
import com.vald3nir.smart_energy.data.repository.remote.sensors.SensorsRepository
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

class PersistenceUseCaseImpl @Inject constructor(
    private val contractRepository: ContractRepository,
    private val sensorsRepository: SensorsRepository,
    private val historicRepository: HistoricRepository,
) : PersistenceUseCase {

    override suspend fun forceUpdateDatabase(
        email: String, onSuccess: () -> Unit, onError: ((Exception?) -> Unit)?
    ) {
        updateContractLocal(email, onSuccess, onError)
    }

    private fun updateContractLocal(
        email: String, onSuccess: () -> Unit, onError: ((Exception?) -> Unit)?
    ) = runBlocking {
        contractRepository.loadContract(email = email, onError = onError, onSuccess = { contract ->
            runBlocking {
                contractRepository.updateContractLocal(
                    contract = contract,
                    onError = onError,
                    onSuccess = {
                        updateSensorsLocal(email, contract, onSuccess, onError)
                    },
                )
            }
        })
    }

    private fun updateSensorsLocal(
        email: String,
        contractDTO: ContractDTO?, onSuccess: () -> Unit,
        onError: ((Exception?) -> Unit)?
    ) = runBlocking {
        sensorsRepository.loadSensors(
            contractDTO = contractDTO,
            onError = onError,
            onSuccess = { sensors ->
                runBlocking {
                    sensorsRepository.updateSensorsLocal(
                        sensors = sensors.filterNotNull(),
                        onError = onError,
                        onSuccess = {
                            updateHistoricLocal(email, onSuccess, onError)
                        }
                    )
                }
            }
        )
    }

    private fun updateHistoricLocal(
        email: String,
        onSuccess: () -> Unit,
        onError: ((Exception?) -> Unit)?
    ) = runBlocking {
        historicRepository.loadHistoric(
            email = email,
            onError = onError,
            onSuccess = { historic ->
                runBlocking {
                    historicRepository.updateHistoricLocal(
                        historic = historic,
                        onError = onError,
                        onSuccess = onSuccess
                    )
                }
            }
        )
    }
}