package com.vald3nir.onboarding.presentation.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import com.vald3nir.commons.views.BaseFragment
import com.vald3nir.onboarding.presentation.OnboardingViewModel
import com.vald3nir.onboarding.R
import com.vald3nir.onboarding.databinding.FragmentWelcomeBinding

class WelcomeFragment : BaseFragment(R.layout.fragment_welcome) {

    private lateinit var binding: FragmentWelcomeBinding
    private val viewModel: OnboardingViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentWelcomeBinding.bind(view)
        initViews()
    }

    private fun initViews() {
        setupButtons()
    }

    private fun setupButtons() = with(binding) {
        btnGoogleLogin.setup(this@WelcomeFragment)
        linkDemostrate.setOnClickListener { } //valdenir add new router
    }

    override fun onResume() {
        super.onResume()
        loadUserGoogle()
    }

    private fun loadUserGoogle() {
        viewModel.loadUserGoogle(
            activity = activity,
            onError = { showLoading(false) },
            onSuccess = {

            }
        )
    }
}