package com.vald3nir.smart_energy.presentation

import com.vald3nir.commons.views.BaseViewModel
import com.vald3nir.onboarding.presentation.redirectToOnboarding
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
//    private val persistenceUseCase: PersistenceUseCase,
//    private val authUseCase: AuthUseCase,
//    private val contractUseCase: ContractUseCase,
) : BaseViewModel() {

    fun startFlows(mainActivity: MainActivity) {
//        showLoading(true)
        mainActivity.redirectToOnboarding()
    }
}