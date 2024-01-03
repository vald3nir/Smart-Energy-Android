package com.vald3nir.smart_energy.domain.common.view

import androidx.annotation.LayoutRes
import com.vald3nir.auth.google.GoogleSign
import com.vald3nir.core.presentation.CoreFragment

abstract class BaseFragment(@LayoutRes contentLayoutID: Int) : CoreFragment(contentLayoutID) {

    fun getBaseActivity(): BaseActivity? {
        return activity as? BaseActivity
    }


    fun callGoogleSignIn() {
        GoogleSign.googleAuthenticate(activity)
    }

    override fun onStop() {
        super.onStop()
        showLoading(false)
    }
}


