package com.vald3nir.smart_energy.domain.use_cases.app_preferences

import android.content.Context
import com.vald3nir.smart_energy.data.dtos.AppPreferencesDTO

interface AppPreferencesUseCase {
    suspend fun loadAppPreferences(context: Context?): AppPreferencesDTO
    suspend fun saveAppPreferences(
        context: Context?,
        appPreferencesDTO: AppPreferencesDTO,
        onSuccess: (() -> Unit)? = null
    )
}