package com.vald3nir.onboarding.presentation

import android.app.Activity
import androidx.lifecycle.viewModelScope
import com.vald3nir.commons.use_cases.AuthUseCase
import com.vald3nir.commons.views.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnboardingViewModel @Inject constructor(
    private val authUseCase: AuthUseCase,
) : BaseViewModel() {

    fun loadUserGoogle(activity: Activity?, onError: () -> Unit, onSuccess: () -> Unit) {
        viewModelScope.launch {
            authUseCase.loadUserGoogle(
                activity = activity,
                onError = onError,
                onSuccess = { onSuccess.invoke() }
            )
        }
    }
}