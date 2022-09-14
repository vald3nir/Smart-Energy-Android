package com.vald3nir.smart_energy.presentation.splash

import android.app.Activity
import androidx.lifecycle.viewModelScope
import com.vald3nir.smart_energy.data.dtos.GoogleUserDTO
import com.vald3nir.smart_energy.domain.common.view.BaseViewModel
import com.vald3nir.smart_energy.domain.use_cases.auth.AuthUseCase
import com.vald3nir.smart_energy.domain.use_cases.contract.ContractUseCase
import com.vald3nir.smart_energy.domain.use_cases.persistence.PersistenceUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class SplashViewModel @Inject constructor(
    private val persistenceUseCase: PersistenceUseCase,
    private val authUseCase: AuthUseCase,
    private val contractUseCase: ContractUseCase,
) : BaseViewModel() {

    private var user: GoogleUserDTO? = null

    fun checkUserLogged(
        activity: Activity,
        onSuccess: () -> Unit,
        onError: () -> Unit
    ) {
        viewModelScope.launch {
            authUseCase.loadUserGoogle(
                activity = activity,
                onSuccess = {
                    user = it
                    onSuccess.invoke()
                },
                onError = onError
            )
        }
    }

    fun checkDatabase(onSuccess: () -> Unit, onError: ((Exception?) -> Unit)?) {
        viewModelScope.launch {
            contractUseCase.loadContractLocal(
                onError = onError,
                onSuccess = {
                    if (it == null) {
                        updateDatabase(onSuccess, onError)
                    } else {
                        onSuccess.invoke()
                    }
                },
            )
        }
    }

    private fun updateDatabase(onSuccess: () -> Unit, onError: ((Exception?) -> Unit)?) {
        viewModelScope.launch {
            persistenceUseCase.forceUpdateDatabase(
                email = user?.email.orEmpty(),
                onError = onError,
                onSuccess = onSuccess
            )
        }
    }
}