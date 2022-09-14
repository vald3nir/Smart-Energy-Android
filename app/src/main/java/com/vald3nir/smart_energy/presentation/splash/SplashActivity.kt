package com.vald3nir.smart_energy.presentation.splash

import android.os.Bundle
import androidx.activity.viewModels
import com.vald3nir.smart_energy.databinding.ActivityEmptyBinding
import com.vald3nir.smart_energy.domain.common.view.BaseActivity
import com.vald3nir.smart_energy.presentation.home.redirectToHome
import com.vald3nir.smart_energy.presentation.onboarding.redirectToOnboarding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class SplashActivity : BaseActivity() {

    private val viewModel: SplashViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityEmptyBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        showLoading(true)
        viewModel.checkUserLogged(
            activity = this,
            onSuccess = { updateContract() },
            onError = { redirectToOnboarding() })
    }

    private fun updateContract() {
        viewModel.checkDatabase(
            onSuccess = {
                redirectToHome()
            },
            onError = {
                showMessage(it?.message)
            }
        )
    }
}