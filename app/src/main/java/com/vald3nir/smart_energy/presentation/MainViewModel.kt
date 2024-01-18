package com.vald3nir.smart_energy.presentation

import androidx.lifecycle.viewModelScope
import com.vald3nir.commons.domain.AppNavigator
import com.vald3nir.commons.domain.use_cases.AuthUseCase
import com.vald3nir.commons.views.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val appNavigator: AppNavigator,
    private val authUseCase: AuthUseCase,
) : BaseViewModel() {

    fun startFlows(activity: MainActivity) {
        showLoading(true)
        viewModelScope.launch {
            authUseCase.loadUserGoogle(
                activity = activity,
                onError = {
                    showLoading(false)
                    appNavigator.redirectToOnboarding(activity)
                },
                onSuccess = { appNavigator.redirectToHome(activity) }
            )
        }
    }
}