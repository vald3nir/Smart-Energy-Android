package com.vald3nir.smart_energy.domain.use_cases.persistence

interface PersistenceUseCase {

    suspend fun forceUpdateDatabase(
        email: String,
        onSuccess: () -> Unit,
        onError: ((Exception?) -> Unit)? = null
    )

}