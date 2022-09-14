package com.vald3nir.smart_energy.domain.use_cases.app_preferences

import android.content.Context
import com.vald3nir.smart_energy.data.dtos.AppPreferencesDTO
import com.vald3nir.smart_energy.data.repository.remote.preferences.AppPreferencesRepository
import javax.inject.Inject

class AppPreferencesUseCaseImpl @Inject constructor(
    private val repository: AppPreferencesRepository
) : AppPreferencesUseCase {

    override suspend fun loadAppPreferences(context: Context?): AppPreferencesDTO {
        return repository.loadAppPreferencesLocal(context)
    }

    override suspend fun saveAppPreferences(
        context: Context?,
        appPreferencesDTO: AppPreferencesDTO,
        onSuccess: (() -> Unit)?
    ) {
        repository.saveAppPreferencesLocal(context, appPreferencesDTO, onSuccess)
    }
}