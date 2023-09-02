package com.vald3nir.smart_energy.presentation.home.extensions

import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import com.vald3nir.extensions.toIntOrZero
import com.vald3nir.extensions.views.formatStringResources
import com.vald3nir.extensions.views.setTextColorTo
import com.vald3nir.smart_energy.R
import com.vald3nir.smart_energy.data.dtos.DashboardDTO
import com.vald3nir.smart_energy.data.dtos.SensorDTO
import com.vald3nir.smart_energy.databinding.ItemViewCompactDashboardBinding
import com.vald3nir.smart_energy.databinding.ItemViewDashboardBinding
import com.vald3nir.smart_energy.domain.common.DEFAULT_VALUE_FOR_MAX_POWER_CONSUMPTION
import com.vald3nir.smart_energy.domain.common.PERCENTAGE_MAX_VALUE_FOR_INTERMEDIARY_POWER_CONSUMPTION
import com.vald3nir.smart_energy.domain.common.PERCENTAGE_MAX_VALUE_FOR_NORMAL_POWER_CONSUMPTION
import kotlin.math.roundToInt

fun ItemViewDashboardBinding.bind(sensor: SensorDTO) {
    cpEnergyConsumptionIndicator.setLabelValues(
        maxValue = DEFAULT_VALUE_FOR_MAX_POWER_CONSUMPTION,
        textColorID = R.color.item_view_background_color,
        sliceSize = 25f
    )
    txvSensorName.text = sensor.alias
}

fun ItemViewDashboardBinding.updateIndicator(dashboardDTO: DashboardDTO) {
    txvLevelConsumption.addLabelConsumptionLevelStyle(
        power = dashboardDTO.power,
        maxValue = DEFAULT_VALUE_FOR_MAX_POWER_CONSUMPTION
    )
    txvInstantPowerConsumed.addValueConsumptionLevelStyle(
        power = dashboardDTO.power,
        maxValue = DEFAULT_VALUE_FOR_MAX_POWER_CONSUMPTION
    )
    txvTemperatureValue.apply {
        text = formatStringResources(
            R.string.format_temperature_value, dashboardDTO.temperature?.roundToInt()
        )
    }
    txvAirHumidity.apply {
        text = formatStringResources(
            R.string.format_humidity_value, dashboardDTO.humidity
        )
    }
    cpEnergyConsumptionIndicator.animateProgress(dashboardDTO.power.toIntOrZero())
}

fun ItemViewCompactDashboardBinding.bind(sensor: SensorDTO) {
    cpEnergyConsumptionIndicator.setLabelValues(
        maxValue = DEFAULT_VALUE_FOR_MAX_POWER_CONSUMPTION,
        textColorID = R.color.white,
        sliceSize = 15f
    )
    txvSensorName.text = sensor.alias
}

fun ItemViewCompactDashboardBinding.updateIndicator(
    dashboardDTO: DashboardDTO
) {
    cpEnergyConsumptionIndicator.animateProgress(dashboardDTO.power.toIntOrZero())
}


fun TextView.addLabelConsumptionLevelStyle(power: Double?, maxValue: Int) {
    val param = power?.toFloat() ?: 0f
    val maxLimit = maxValue.toFloat()
    val normalLimit: Float = PERCENTAGE_MAX_VALUE_FOR_NORMAL_POWER_CONSUMPTION * maxLimit
    val averageLimit: Float = PERCENTAGE_MAX_VALUE_FOR_INTERMEDIARY_POWER_CONSUMPTION * maxLimit

    when {
        param <= normalLimit -> {
            text = context.getText(R.string.normal)
            setTextColorTo(R.color.green)
        }

        param <= averageLimit -> {
            text = context.getText(R.string.moderate)
            setTextColorTo(R.color.yellow)
        }

        else -> {
            text = context.getText(R.string.high)
            setTextColorTo(R.color.red)
        }
    }
}

fun TextView.addValueConsumptionLevelStyle(power: Double?, maxValue: Int) {
    val param = power?.toFloat() ?: 0f
    val maxLimit = maxValue.toFloat()
    val normalLimit: Float = PERCENTAGE_MAX_VALUE_FOR_NORMAL_POWER_CONSUMPTION * maxLimit
    val averageLimit: Float = PERCENTAGE_MAX_VALUE_FOR_INTERMEDIARY_POWER_CONSUMPTION * maxLimit
    text = context.formatStringResources(R.string.format_watts_value, param)
    setTextColorTo(
        when {
            param <= normalLimit -> R.color.green
            param <= averageLimit -> R.color.yellow
            else -> R.color.red
        }
    )
}

fun sensorsDiffUtil(): DiffUtil.ItemCallback<SensorDTO> =
    object : DiffUtil.ItemCallback<SensorDTO>() {

        override fun areItemsTheSame(
            oldItem: SensorDTO,
            newItem: SensorDTO
        ): Boolean {
            return oldItem.alias == newItem.alias
        }

        override fun areContentsTheSame(
            oldItem: SensorDTO,
            newItem: SensorDTO
        ): Boolean {
            return oldItem == newItem
        }
    }