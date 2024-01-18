package com.vald3nir.commons.domain

import android.app.Activity

interface AppNavigator {
    fun redirectToOnboarding(activity: Activity?)
    fun redirectToHome(activity: Activity?)
}