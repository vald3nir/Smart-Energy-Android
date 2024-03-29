package com.vald3nir.smart_energy.presentation.onboarding

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.vald3nir.smart_energy.databinding.ActivityOnboardingBinding
import com.vald3nir.smart_energy.domain.common.view.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OnboardingActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityOnboardingBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}

fun Activity.redirectToOnboarding() {
    startActivity(Intent(this, OnboardingActivity::class.java))
}