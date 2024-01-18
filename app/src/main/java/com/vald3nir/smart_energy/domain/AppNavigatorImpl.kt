package com.vald3nir.smart_energy.domain

import android.app.Activity
import com.vald3nir.commons.domain.AppNavigator
import com.vald3nir.home.presentation.redirectToHome
import com.vald3nir.onboarding.presentation.redirectToOnboarding
import javax.inject.Inject

class AppNavigatorImpl @Inject constructor() : AppNavigator {

    override fun redirectToOnboarding(activity: Activity?) {
        activity?.redirectToOnboarding()
    }

    override fun redirectToHome(activity: Activity?) {
        activity?.redirectToHome()
    }
}