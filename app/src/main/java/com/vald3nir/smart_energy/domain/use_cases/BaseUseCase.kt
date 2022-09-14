package com.vald3nir.smart_energy.domain.use_cases

import android.content.Context
import com.vald3nir.smart_energy.domain.use_cases.app_preferences.AppPreferencesUseCase

open class BaseUseCase(private val appPreferencesUseCase: AppPreferencesUseCase) {

    suspend fun isDemoMode(context: Context?) =
        appPreferencesUseCase.loadAppPreferences(context).useDemoMode

}