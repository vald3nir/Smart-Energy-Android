package com.vald3nir.onboarding

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.vald3nir.commons.views.BaseActivity
import com.vald3nir.onboarding.databinding.ActivityOnboardingBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OnboardingActivity : BaseActivity() {

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        val binding = ActivityOnboardingBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//    }
}

fun Activity.redirectToOnboarding() {
    startActivity(Intent(this, OnboardingActivity::class.java))
}