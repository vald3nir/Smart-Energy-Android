package com.vald3nir.smart_energy.data.repository.remote.preferences

import android.content.Context
import com.vald3nir.extensions.fromJson
import com.vald3nir.extensions.loadDataString
import com.vald3nir.extensions.saveDataString
import com.vald3nir.extensions.toJson
import com.vald3nir.smart_energy.data.dtos.AppPreferencesDTO
import javax.inject.Inject

class AppPreferencesRepositoryImpl @Inject constructor(): AppPreferencesRepository {

    private val appConfigKey = "appPreferenceKey"

    override suspend fun loadAppPreferencesLocal(context: Context?): AppPreferencesDTO {
        val data = context?.loadDataString(appConfigKey) ?: return AppPreferencesDTO()
        return fromJson(data, AppPreferencesDTO::class.java)
    }

    override suspend fun saveAppPreferencesLocal(
        context: Context?,
        appPreferencesDTO: AppPreferencesDTO,
        onSuccess: (() -> Unit)?
    ) {
        context?.saveDataString(key = appConfigKey, data = appPreferencesDTO.toJson())
        onSuccess?.invoke()
    }
}