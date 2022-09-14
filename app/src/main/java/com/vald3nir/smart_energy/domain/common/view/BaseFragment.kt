package com.vald3nir.smart_energy.domain.common.view

import com.vald3nir.core_repository.auth.googleSignIn
import com.vald3nir.core_ui.CoreFragment

abstract class BaseFragment : CoreFragment() {

    fun getBaseActivity(): BaseActivity? {
        return activity as? BaseActivity
    }

    fun showLoading(show: Boolean) {
        (activity as? BaseActivity)?.showLoading(show)
    }

    fun callGoogleSignIn() {
        activity?.googleSignIn()
    }

    override fun onStop() {
        super.onStop()
        showLoading(false)
    }
}


