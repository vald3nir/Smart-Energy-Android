package com.vald3nir.smart_energy.data.repository.remote.contract

import com.vald3nir.core_repository.firebase.FirebaseDB
import com.vald3nir.core_repository.firebase.FirebaseDB.parseStringToObject
import com.vald3nir.smart_energy.data.database.daos.ContractDAO
import com.vald3nir.smart_energy.data.dtos.ContractDTO
import com.vald3nir.smart_energy.domain.mappers.asDTO
import com.vald3nir.smart_energy.domain.mappers.asEntity
import com.vald3nir.smart_energy.domain.utils.parseEmailToKey
import javax.inject.Inject

class ContractRepositoryImpl @Inject constructor(
    private val contractDAO: ContractDAO
) : ContractRepository {


    override suspend fun loadContract(
        email: String,
        onSuccess: (contract: ContractDTO?) -> Unit,
        onError: ((Exception?) -> Unit)?
    ) {
        val key = email.parseEmailToKey()
        FirebaseDB.readObject(
            path = "/release/contract/${key}",
            onError = onError,
            onSuccess = {
                val contractDTO: ContractDTO? = it?.parseStringToObject()
                onSuccess.invoke(contractDTO)
            },
        )
    }

    override suspend fun loadContractLocal(
        onSuccess: (contract: ContractDTO?) -> Unit,
        onError: ((e: Exception) -> Unit)?
    ) {
        try {
            onSuccess.invoke(contractDAO.getContract().asDTO())
        } catch (e: Exception) {
            onError?.invoke(e)
        }
    }

    override suspend fun updateContractLocal(
        contract: ContractDTO?,
        onSuccess: () -> Unit,
        onError: ((Exception?) -> Unit)?
    ) {
        try {
            contractDAO.clear()
            contractDAO.insertContract(contract.asEntity())
            onSuccess.invoke()
        } catch (e: Exception) {
            onError?.invoke(e)
        }
    }

}