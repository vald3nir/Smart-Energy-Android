package com.vald3nir.smart_energy.presentation.onboarding

import android.app.Activity
import androidx.lifecycle.viewModelScope
import com.vald3nir.smart_energy.domain.common.view.BaseViewModel
import com.vald3nir.smart_energy.domain.use_cases.auth.AuthUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnboardingViewModel @Inject constructor(
    private val authUseCase: AuthUseCase,
) : BaseViewModel() {

    fun checkUserLogged(
        activity: Activity?,
        onSuccess: () -> Unit,
    ) {
        viewModelScope.launch {
            authUseCase.loadUserGoogle(
                activity = activity,
                onSuccess = { onSuccess.invoke() }
            )
        }
    }

    fun authenticateUser(
        activity: Activity,
    ) {
        viewModelScope.launch {
            authUseCase.authenticateWithGoogle(activity = activity)
        }
    }

}
