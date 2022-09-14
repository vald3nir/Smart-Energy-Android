package com.vald3nir.smart_energy.data.repository.remote.historic

import com.vald3nir.smart_energy.data.dtos.HistoricDTO

interface HistoricRepository {

    suspend fun loadHistoric(
        email: String,
        onSuccess: (List<HistoricDTO>) -> Unit,
        onError: ((Exception?) -> Unit)?
    )

    suspend fun loadHistoricLocal(
        onSuccess: (List<HistoricDTO>) -> Unit,
        onError: ((e: Exception) -> Unit)?
    )

    suspend fun updateHistoricLocal(
        historic: List<HistoricDTO>,
        onSuccess: () -> Unit,
        onError: ((Exception?) -> Unit)?
    )
}