package com.vald3nir.smart_energy.domain.use_cases.contract

import com.vald3nir.smart_energy.data.dtos.ContractDTO
import com.vald3nir.smart_energy.data.repository.remote.contract.ContractRepository
import javax.inject.Inject

class ContractUseCaseImpl @Inject constructor(
    private val repository: ContractRepository
) : ContractUseCase {

    override suspend fun loadContract(
        email: String,
        onSuccess: (contract: ContractDTO?) -> Unit,
        onError: ((Exception?) -> Unit)?
    ) {
        repository.loadContract(email, onSuccess, onError)
    }

    override suspend fun loadContractLocal(
        onSuccess: (contract: ContractDTO?) -> Unit,
        onError: ((e: Exception) -> Unit)?
    ) {
        repository.loadContractLocal(onSuccess, onError)
    }

    override suspend fun updateContractLocal(
        contract: ContractDTO?,
        onSuccess: () -> Unit,
        onError: ((Exception?) -> Unit)?
    ) {
        repository.updateContractLocal(contract, onSuccess, onError)
    }
}