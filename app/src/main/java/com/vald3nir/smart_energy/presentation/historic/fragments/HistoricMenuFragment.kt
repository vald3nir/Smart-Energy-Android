package com.vald3nir.smart_energy.presentation.historic.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.vald3nir.core_ui.components.CustomDifferAdapter
import com.vald3nir.core_ui.extensions.setupDefaultLayoutManager
import com.vald3nir.smart_energy.data.dtos.ItemMenuEnum
import com.vald3nir.smart_energy.databinding.FragmentMenuHistoricBinding
import com.vald3nir.smart_energy.databinding.ItemViewMenuHistoricBinding
import com.vald3nir.smart_energy.domain.common.view.BaseFragment
import com.vald3nir.smart_energy.presentation.historic.HistoricViewModel
import com.vald3nir.smart_energy.presentation.historic.extensions.bindItem
import com.vald3nir.smart_energy.presentation.historic.extensions.historicItemMenuDiffUtil
import com.vald3nir.smart_energy.presentation.historic.getUserLogged

class HistoricMenuFragment : BaseFragment() {

    // ---------------------------------------------------------------------------------------------
    // VARIABLES
    // ---------------------------------------------------------------------------------------------

    private lateinit var binding: FragmentMenuHistoricBinding
    private val viewModel: HistoricViewModel by activityViewModels()

    // ---------------------------------------------------------------------------------------------
    // LIST ADAPTER
    // ---------------------------------------------------------------------------------------------

    private val menuAdapter by lazy {
        val adapter = CustomDifferAdapter(bindingInflater = ItemViewMenuHistoricBinding::inflate,
            list = viewModel.loadHistoricItemsMenu(),
            itemDiffUtil = historicItemMenuDiffUtil(),
            onBind = { item, binding, _, _ ->
                binding.bindItem(item) { redirectTo(it) }
            })
        adapter
    }

    // ---------------------------------------------------------------------------------------------
    // REDIRECTS
    // ---------------------------------------------------------------------------------------------

    private fun redirectTo(enum: ItemMenuEnum) {
        when (enum) {
            ItemMenuEnum.LAST_HOURS -> {
                navigateTo(HistoricMenuFragmentDirections.actionMoveToConsumptionLastHoursFragment())
            }

            ItemMenuEnum.SELECTED_DAY -> {
            }

            ItemMenuEnum.LAST_DAYS -> {
                navigateTo(HistoricMenuFragmentDirections.actionMoveToConsumptionLastDaysFragment())
            }

            ItemMenuEnum.LAST_MONTHS -> {
                navigateTo(HistoricMenuFragmentDirections.actionMoveToConsumptionLastMonthsDaysFragment())
            }

            ItemMenuEnum.ENVIRONMENT -> {}
            ItemMenuEnum.SOLAR_GENERATION -> {}
        }
    }

    // ---------------------------------------------------------------------------------------------
    // ANDROID LIFECYCLE
    // ---------------------------------------------------------------------------------------------

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?,
    ): View {
        binding = FragmentMenuHistoricBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.userLogged = activity?.getUserLogged()
        initViews()
        loadHistoric()
    }

    private fun initViews() = with(binding) {
        toolbar.enableClickEvents(requireCoreActivity())
        btnUpdateDatabase.setOnClickListener { updateDatabase() }
        rvMenu.apply {
            setupDefaultLayoutManager()
            adapter = menuAdapter
        }
    }

    private fun updateDatabase() {
        showLoading(true)
        viewModel.updateDatabase(
            onSuccess = { showLoading(false) },
            onError = {
                showLoading(false)
                showMessage(it?.message)
            }
        )
    }

    private fun loadHistoric() {
        showLoading(true)
        viewModel.loadHistoric(
            onSuccess = { showLoading(false) },
            onError = {
                showLoading(false)
                showMessage(it)
            }
        )
    }
}