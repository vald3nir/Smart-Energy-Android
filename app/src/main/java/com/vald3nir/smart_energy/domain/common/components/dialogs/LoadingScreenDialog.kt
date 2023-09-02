package com.vald3nir.smart_energy.domain.common.components.dialogs

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.animation.AnimationUtils
import com.vald3nir.smart_energy.R
import com.vald3nir.smart_energy.databinding.ComponentLoadingScreenBinding
import com.vald3nir.ui.components.atoms.CustomImageView

class LoadingScreenDialog(context: Context) : Dialog(context, R.style.full_screen_dialog) {

    private lateinit var binding: ComponentLoadingScreenBinding

    init {
        setCancelable(true)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window?.setBackgroundDrawable(ColorDrawable(Color.BLACK))

        binding = ComponentLoadingScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        showAnimation()
    }

    private fun showAnimation() = with(binding) {
        imvLogo.showLoadingAnimation()
    }

    private fun CustomImageView.showLoadingAnimation() {
        startAnimation(
            AnimationUtils.loadAnimation(context, R.anim.rotate_indefinitely)
        )
    }
}