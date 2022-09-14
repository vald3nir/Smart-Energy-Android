package com.vald3nir.smart_energy.presentation.home

import android.app.Activity
import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.vald3nir.smart_energy.data.dtos.AppPreferencesDTO
import com.vald3nir.smart_energy.data.dtos.DashboardDTO
import com.vald3nir.smart_energy.data.dtos.GoogleUserDTO
import com.vald3nir.smart_energy.data.dtos.SensorDTO
import com.vald3nir.smart_energy.domain.common.view.BaseViewModel
import com.vald3nir.smart_energy.domain.use_cases.app_preferences.AppPreferencesUseCase
import com.vald3nir.smart_energy.domain.use_cases.auth.AuthUseCase
import com.vald3nir.smart_energy.domain.use_cases.dashboard.DashboardUseCase
import com.vald3nir.smart_energy.domain.use_cases.sensors.SensorsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val authUseCase: AuthUseCase,
    private val dashboardUseCase: DashboardUseCase,
    private val sensorsUseCase: SensorsUseCase,
    private val appPreferencesUseCase: AppPreferencesUseCase,
) : BaseViewModel() {

    private var appPreferences: AppPreferencesDTO? = null

    private val _sensors = MutableLiveData<List<SensorDTO>>()
    val sensors: LiveData<List<SensorDTO>> = _sensors

    private val _userLogged = MutableLiveData<GoogleUserDTO>()
    val userLogged: LiveData<GoogleUserDTO> = _userLogged

    fun loadUserAuthenticated(activity: Activity?, onError: () -> Unit) {
        viewModelScope.launch {
            authUseCase.loadUserGoogle(activity = activity, onError = onError, onSuccess = {
                _userLogged.value = it
            })
        }
    }

    fun loadSensors() {
        viewModelScope.launch {
            sensorsUseCase.loadSensors(
                onSuccess = { sensors ->
                    _sensors.value = sensors.filterNotNull()
                }, onError = {}
            )
        }
    }


    fun useDashboardCompact() = appPreferences?.useCompactDashboardCharts == true
    fun updateDashboardCompactMode(context: Context?, enable: Boolean) {
        context?.let {
            appPreferences?.useCompactDashboardCharts = enable
            saveAppPreferences(it)
        }
    }

    fun loadAppPreferences(
        context: Context?,
        onSuccess: () -> Unit
    ) {
        viewModelScope.launch {
            appPreferences = appPreferencesUseCase.loadAppPreferences(context)
            onSuccess.invoke()
        }
    }


    fun saveAppPreferences(
        context: Context?,
        onSuccess: (() -> Unit)? = null
    ) {
        appPreferences?.let { preferences ->
            viewModelScope.launch {
                appPreferencesUseCase.saveAppPreferences(context, preferences, onSuccess)
            }
        }
    }


    fun unsubscriberDashboardTopic() {
        dashboardUseCase.unsubscriberDashboardTopic()
    }

    fun registerTopics(
        context: Context?,
        sensor: SensorDTO,
        onResponse: (dashboardDTO: DashboardDTO) -> Unit,
    ) {
        viewModelScope.launch {
            dashboardUseCase.subscriberDashboardTopic(
                context = context,
                sensor = sensor,
                onResponse = { dashboard ->
                    runOnMainThread { onResponse.invoke(dashboard) }
                }
            )
        }
    }

}