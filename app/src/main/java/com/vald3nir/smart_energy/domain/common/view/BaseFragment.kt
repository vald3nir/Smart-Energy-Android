package com.vald3nir.smart_energy.domain.common.view

import com.vald3nir.auth.google.googleSignIn
import com.vald3nir.ui.base_views.CoreFragment

abstract class BaseFragment : CoreFragment() {

    fun requireCoreActivity() = requireActivity()

    fun showMessage(msg: String?) {}
    fun showError(e: Exception?) {}

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


