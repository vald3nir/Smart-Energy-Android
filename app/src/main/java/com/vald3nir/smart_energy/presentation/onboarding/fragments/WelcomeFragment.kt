package com.vald3nir.smart_energy.presentation.onboarding.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.vald3nir.smart_energy.databinding.FragmentWelcomeBinding
import com.vald3nir.smart_energy.domain.common.view.BaseActivity
import com.vald3nir.smart_energy.domain.common.view.BaseFragment
import com.vald3nir.smart_energy.presentation.onboarding.OnboardingViewModel

class WelcomeFragment : BaseFragment() {

    private lateinit var binding: FragmentWelcomeBinding
    private val viewModel: OnboardingViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWelcomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun initViews() = with(binding) {
        btnLogin.setOnClickListener { callGoogleSignIn() }
        linkDemostrate.setOnClickListener { } //valdenir add new router
    }

    override fun onResume() {
        super.onResume()
        getBaseActivity().checkUserLogged()
    }

    private fun BaseActivity?.checkUserLogged() {
        this?.let { baseActivity ->
            viewModel.checkUserLogged(
                activity = baseActivity,
                onSuccess = { baseActivity.finish() }
            )
        }
    }
}