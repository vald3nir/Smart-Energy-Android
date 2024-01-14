package com.vald3nir.commons.views

import android.widget.Toast
import com.vald3nir.commons.R
import com.vald3nir.core.presentation.CoreActivity
import com.vald3nir.core.presentation.animations.TypeAnimation
import com.vald3nir.core.presentation.components.screens.LoadingScreenDialog

open class BaseActivity : CoreActivity() {

    private var loadingScreenDialog: LoadingScreenDialog? = null

    override fun showError(e: Exception?) {
        showLoading(false)
        e?.let {
            it.printStackTrace()
            showMessage(it.message)
        }
    }

    override fun showMessage(msg: String?) {
        showLoading(false)
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

    override fun showLoading(show: Boolean) {
        postSimpleDelayed(delayMillis = 1000, callback = {
            loadingScreenDialog?.dismiss()
            if (show) {
                loadingScreenDialog = LoadingScreenDialog(
                    context = this,
                    title = getString(R.string.loading),
                    icon = R.drawable.ic_logo,
                    typeAnimation = TypeAnimation.ROTATION
                )
                loadingScreenDialog?.show()
            }
        })
    }
}