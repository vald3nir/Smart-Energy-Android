package com.vald3nir.smart_energy.presentation.historic.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.github.aachartmodel.aainfographics.aachartcreator.AAChartType
import com.vald3nir.smart_energy.R
import com.vald3nir.smart_energy.databinding.FragmentConsumptionBinding
import com.vald3nir.smart_energy.domain.common.view.BaseFragment
import com.vald3nir.smart_energy.presentation.historic.HistoricViewModel
import com.vald3nir.smart_energy.presentation.historic.extensions.setup

class ConsumptionLastDaysFragment : BaseFragment() {

    // ---------------------------------------------------------------------------------------------
    // VARIABLES
    // ---------------------------------------------------------------------------------------------

    private lateinit var binding: FragmentConsumptionBinding
    private val viewModel: HistoricViewModel by activityViewModels()

    // ---------------------------------------------------------------------------------------------
    // ANDROID LIFECYCLE
    // ---------------------------------------------------------------------------------------------

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?,
    ): View {
        binding = FragmentConsumptionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun initViews() = with(binding) {
        toolbar.enableClickEvents(requireCoreActivity())
        aaChartView.setup(
            title = getString(R.string.consumption_last_days),
            dto = viewModel.loadConsumptionLastDays(),
            type = AAChartType.Column
        )
    }
}