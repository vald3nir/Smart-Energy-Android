package com.vald3nir.smart_energy.data.dtos

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HistoricDTO(
    @SerialName("sensor_alias") val sensorAlias: String?,
    @SerialName("consumption_days") val consumptionDays: List<ConsumptionDTO>,
    @SerialName("consumption_hours") val consumptionHours: List<ConsumptionDTO>,
    @SerialName("consumption_months") val consumptionMonths: List<ConsumptionDTO>,
    @SerialName("consumption_years") val consumptionYears: List<ConsumptionDTO>,
)