package com.vald3nir.smart_energy.data.repository.remote.preferences

import android.content.Context
import com.vald3nir.smart_energy.data.dtos.AppPreferencesDTO

interface AppPreferencesRepository {
    suspend fun loadAppPreferencesLocal(context: Context?): AppPreferencesDTO
    suspend fun saveAppPreferencesLocal(
        context: Context?,
        appPreferencesDTO: AppPreferencesDTO,
        onSuccess: (() -> Unit)?
    )
}