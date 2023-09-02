package com.vald3nir.smart_energy.domain.common.view

import com.vald3nir.smart_energy.domain.common.components.dialogs.LoadingScreenDialog
import com.vald3nir.ui.base_views.CoreActivity

open class BaseActivity : CoreActivity() {

    private var loading: LoadingScreenDialog? = null

    fun showLoading(show: Boolean) {
        if (show) {
            loading = LoadingScreenDialog(this)
            loading?.show()
        } else {
            loading?.dismiss()
        }
    }

    override fun showError(e: Exception) {
       
    }

    override fun showMessage(msg: String?) {
       
    }

    override fun showLoading(msg: String?) {
       
    }

    override fun onStop() {
        super.onStop()
        loading?.dismiss()
    }


}