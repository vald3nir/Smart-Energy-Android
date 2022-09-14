package com.vald3nir.smart_energy.domain.use_cases.historic

import com.vald3nir.smart_energy.data.dtos.HistoricDTO

interface HistoricUseCase {

    suspend fun loadHistoricLocal(
        onSuccess: (List<HistoricDTO>) -> Unit,
        onError: ((e: Exception) -> Unit)?
    )

}