package com.vald3nir.smart_energy.domain.use_cases.historic

import com.vald3nir.smart_energy.data.dtos.HistoricDTO
import com.vald3nir.smart_energy.data.repository.remote.historic.HistoricRepository
import com.vald3nir.smart_energy.domain.use_cases.BaseUseCase
import com.vald3nir.smart_energy.domain.use_cases.app_preferences.AppPreferencesUseCase
import javax.inject.Inject

class HistoricUseCaseImpl @Inject constructor(
    private val repository: HistoricRepository,
    appPreferencesUseCase: AppPreferencesUseCase,
) : HistoricUseCase, BaseUseCase(appPreferencesUseCase) {

    override suspend fun loadHistoricLocal(
        onSuccess: (List<HistoricDTO>) -> Unit,
        onError: ((e: Exception) -> Unit)?
    ) {
        repository.loadHistoricLocal(onSuccess, onError)
    }

}