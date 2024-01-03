package com.vald3nir.smart_energy.presentation.historic

import androidx.lifecycle.viewModelScope
import com.vald3nir.auth.google.GoogleUserDTO
import com.vald3nir.smart_energy.R
import com.vald3nir.smart_energy.data.dtos.ChartDTO
import com.vald3nir.smart_energy.data.dtos.DataChartDTO
import com.vald3nir.smart_energy.data.dtos.HistoricDTO
import com.vald3nir.smart_energy.data.dtos.HistoricItemMenuDTO
import com.vald3nir.smart_energy.data.dtos.ItemMenuEnum
import com.vald3nir.smart_energy.domain.common.view.BaseViewModel
import com.vald3nir.smart_energy.domain.use_cases.historic.HistoricUseCase
import com.vald3nir.smart_energy.domain.use_cases.persistence.PersistenceUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HistoricViewModel @Inject constructor(
    private val persistenceUseCase: PersistenceUseCase,
    private val historicUseCase: HistoricUseCase
) : BaseViewModel() {

    var userLogged: GoogleUserDTO? = null
    var historic: List<HistoricDTO> = emptyList()

    fun loadHistoricItemsMenu() = listOf(
        HistoricItemMenuDTO(
            icon = R.drawable.ic_chart_curve,
            title = R.string.consumption_last_hours,
            item = ItemMenuEnum.LAST_HOURS
        ),
//        HistoricItemMenuDTO(
//            icon = R.drawable.ic_chart_line,
//            title = R.string.consumption_throughout_day,
//            item = ItemMenuEnum.SELECTED_DAY
//        ),
        HistoricItemMenuDTO(
            icon = R.drawable.ic_chart_bar,
            title = R.string.consumption_last_days,
            item = ItemMenuEnum.LAST_DAYS
        ),
        HistoricItemMenuDTO(
            icon = R.drawable.ic_chart_bar_cross,
            title = R.string.consumption_last_months,
            item = ItemMenuEnum.LAST_MONTHS
        ),
//        HistoricItemMenuDTO(
//            icon = R.drawable.ic_chart_cross,
//            title = R.string.environment_conditions,
//            item = ItemMenuEnum.ENVIRONMENT
//        ),
//        HistoricItemMenuDTO(
//            icon = R.drawable.ic_fire,
//            title = R.string.solar_power_generation,
//            item = ItemMenuEnum.SOLAR_GENERATION
//        )
    )

    private fun String?.formatHours() = this?.substring(12, 16)

    fun loadConsumptionLastHours(): ChartDTO {
        val item = ChartDTO()
        historic.firstOrNull()?.let { dto ->
            dto.consumptionHours.sortedByDescending { it.date }.subList(0, 24).forEach {
                item.labels.add(it.date.formatHours().orEmpty())
            }
        }
        item.labels.reverse()

        historic.forEach { dto ->
            val data = DataChartDTO(label = dto.sensorAlias.orEmpty())
            dto.consumptionHours.sortedByDescending { it.date }.subList(0, 24).forEach {
                data.values.add((it.power ?: 0.0f) * 1000)
            }
            data.values.reverse()
            item.data.add(data)
        }
        return item
    }

    fun loadConsumptionLastDays(): ChartDTO {
        val item = ChartDTO()
        historic.firstOrNull()?.let { dto ->
            dto.consumptionDays.sortedByDescending { it.date }.subList(0, 30).forEach {
                item.labels.add(it.date.orEmpty())
            }
        }
        item.labels.reverse()

        historic.forEach { dto ->
            val data = DataChartDTO(label = dto.sensorAlias.orEmpty())
            dto.consumptionDays.sortedByDescending { it.date }.subList(0, 30).forEach {
                data.values.add(it.power ?: 0.0f)
            }
            data.values.reverse()
            item.data.add(data)
        }
        return item
    }

    fun loadConsumptionLastMonth(): ChartDTO {
        val item = ChartDTO()
        historic.firstOrNull()?.let { dto ->
            dto.consumptionMonths.sortedByDescending { it.date }.forEach {
                item.labels.add(it.date.orEmpty())
            }
        }
        item.labels.reverse()

        historic.forEach { dto ->
            val data = DataChartDTO(label = dto.sensorAlias.orEmpty())
            dto.consumptionMonths.sortedByDescending { it.date }.forEach {
                data.values.add(it.power ?: 0.0f)
            }
            data.values.reverse()
            item.data.add(data)
        }
        return item
    }


    fun loadHistoric(onSuccess: () -> Unit, onError: ((Exception?) -> Unit)?) {
        viewModelScope.launch {
            historicUseCase.loadHistoricLocal(
                onError = onError,
                onSuccess = {
                    historic = it
                    onSuccess.invoke()
                }
            )
        }
    }

    fun updateDatabase(onSuccess: () -> Unit, onError: ((Exception?) -> Unit)?) {
        viewModelScope.launch {
            persistenceUseCase.forceUpdateDatabase(
                email = userLogged?.email.orEmpty(),
                onError = onError,
                onSuccess = onSuccess
            )
        }
    }

}