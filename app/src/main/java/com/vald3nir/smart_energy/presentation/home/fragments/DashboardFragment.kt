package com.vald3nir.smart_energy.presentation.home.fragments

import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.bumptech.glide.request.RequestOptions
import com.vald3nir.extensions.views.setupDefaultLayoutManager
import com.vald3nir.smart_energy.R
import com.vald3nir.smart_energy.data.dtos.SensorDTO
import com.vald3nir.smart_energy.databinding.FragmentDashboardBinding
import com.vald3nir.smart_energy.databinding.ItemViewCompactDashboardBinding
import com.vald3nir.smart_energy.databinding.ItemViewDashboardBinding
import com.vald3nir.smart_energy.domain.common.view.BaseFragment
import com.vald3nir.smart_energy.presentation.historic.redirectToHistoric
import com.vald3nir.smart_energy.presentation.home.HomeViewModel
import com.vald3nir.smart_energy.presentation.home.extensions.bind
import com.vald3nir.smart_energy.presentation.home.extensions.sensorsDiffUtil
import com.vald3nir.smart_energy.presentation.home.extensions.updateIndicator
import com.vald3nir.smart_energy.presentation.onboarding.redirectToOnboarding
import com.vald3nir.ui.components.adapters.CustomDifferAdapter

class DashboardFragment : BaseFragment() {

    // ---------------------------------------------------------------------------------------------
    // VARIABLES
    // ---------------------------------------------------------------------------------------------

    private lateinit var binding: FragmentDashboardBinding
    private val viewModel: HomeViewModel by activityViewModels()
    private val minNumCell = 2
    private val maxNumCell = 4
    private var numCell = minNumCell


    // ---------------------------------------------------------------------------------------------
    // DASHBOARD'S ADAPTERS
    // ---------------------------------------------------------------------------------------------

    private val dashboardAdapter by lazy {
        val adapter = CustomDifferAdapter(bindingInflater = ItemViewDashboardBinding::inflate,
            list = emptyList(),
            itemDiffUtil = sensorsDiffUtil(),
            onBind = { item, binding, _, _ ->
                binding.bindItem(item)
            })
        adapter
    }

    private fun ItemViewDashboardBinding.bindItem(sensor: SensorDTO) {
        bind(sensor)
        viewModel.registerTopics(requireContext(), sensor) { dashboardDTO ->
            updateIndicator(dashboardDTO)
        }
    }

    private val dashboardCompactAdapter by lazy {
        val adapter =
            CustomDifferAdapter(bindingInflater = ItemViewCompactDashboardBinding::inflate,
                list = emptyList(),
                itemDiffUtil = sensorsDiffUtil(),
                onBind = { item, binding, _, _ ->
                    binding.bindItem(item)
                })
        adapter
    }

    private fun ItemViewCompactDashboardBinding.bindItem(sensor: SensorDTO) {
        bind(sensor)
        viewModel.registerTopics(requireContext(), sensor) { dashboardDTO ->
            updateIndicator(dashboardDTO)
        }
    }

    // ---------------------------------------------------------------------------------------------
    // REDIRECTS
    // ---------------------------------------------------------------------------------------------

    private fun redirectToHistoric() {
        activity?.redirectToHistoric(viewModel.userLogged.value)
    }

    // ---------------------------------------------------------------------------------------------
    // ANDROID LIFECYCLE
    // ---------------------------------------------------------------------------------------------

    override fun onStop() {
        super.onStop()
        viewModel.unsubscriberDashboardTopic()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?,
    ): View {
        binding = FragmentDashboardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObservers()
        initViews()
        viewModel.loadSensors()
        viewModel.loadAppPreferences(context) { setupDashboardCompactMode() }
    }

    private fun initViews() = with(binding) {
        lbKnowMore.setOnClickListener { redirectToHistoric() }
        getBaseActivity()?.let { baseActivity ->
            viewModel.loadUserAuthenticated(
                baseActivity,
                onError = { baseActivity.redirectToOnboarding() })
        }
    }

    private fun setupDashboardCompactMode() = with(binding) {
        scEnableDashboardCompactMode.isChecked = viewModel.useDashboardCompact()
        scEnableDashboardCompactMode.setOnCheckedChangeListener { _, enable ->
            viewModel.updateDashboardCompactMode(context, enable)
            loadDashboardList()
        }
    }

    private fun loadDashboardList() = with(binding.rvSensors) {
        if (viewModel.useDashboardCompact()) {
            layoutManager = GridLayoutManager(requireContext(), numCell)
            adapter = dashboardCompactAdapter
        } else {
            setupDefaultLayoutManager()
            adapter = dashboardAdapter
        }
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            numCell = maxNumCell
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            numCell = minNumCell
        }
        loadDashboardList()
    }

    private fun setupObservers() = with(binding) {
        viewModel.userLogged.observe(viewLifecycleOwner) {
            ivUserProfile.loadImage(
                url = it.profileImageUrl,
                placeholder = R.drawable.ic_logo,
                effect = RequestOptions.circleCropTransform()
            )
            txvUserName.text = it.userName
        }

        viewModel.sensors.observe(viewLifecycleOwner) {
            dashboardCompactAdapter.submitList(it.toMutableList())
            dashboardAdapter.submitList(it.toMutableList())
            loadDashboardList()
        }
    }
}