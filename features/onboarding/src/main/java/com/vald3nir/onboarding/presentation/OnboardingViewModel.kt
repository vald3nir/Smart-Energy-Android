package com.vald3nir.onboarding.presentation

import android.app.Activity
import androidx.lifecycle.viewModelScope
import com.vald3nir.commons.domain.AppNavigator
import com.vald3nir.commons.domain.use_cases.AuthUseCase
import com.vald3nir.commons.views.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnboardingViewModel @Inject constructor(
    private val appNavigator: AppNavigator,
    private val authUseCase: AuthUseCase,
) : BaseViewModel() {

    fun loadUserGoogle(activity: Activity?) {
        viewModelScope.launch {
            authUseCase.loadUserGoogle(
                activity = activity,
                onError = { showLoading(false) },
                onSuccess = { appNavigator.redirectToHome(activity) }
            )
        }
    }
}