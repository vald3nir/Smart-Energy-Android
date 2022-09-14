package com.vald3nir.smart_energy.data.repository.remote.contract

import com.vald3nir.smart_energy.data.dtos.ContractDTO

interface ContractRepository {

    suspend fun loadContract(
        email: String,
        onSuccess: (contract: ContractDTO?) -> Unit,
        onError: ((Exception?) -> Unit)? = null,
    )

    suspend fun loadContractLocal(
        onSuccess: (contract: ContractDTO?) -> Unit,
        onError: ((e: Exception) -> Unit)? = null
    )

    suspend fun updateContractLocal(
        contract: ContractDTO?,
        onSuccess: () -> Unit,
        onError: ((Exception?) -> Unit)? = null
    )
}