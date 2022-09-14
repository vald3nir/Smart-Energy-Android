package com.vald3nir.smart_energy.domain.common.view

import com.vald3nir.core_ui.CoreActivity
import com.vald3nir.smart_energy.domain.common.components.dialogs.LoadingScreenDialog

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

    override fun onStop() {
        super.onStop()
        loading?.dismiss()
    }


}