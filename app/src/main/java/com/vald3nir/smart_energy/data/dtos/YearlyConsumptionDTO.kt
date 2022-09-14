package com.vald3nir.smart_energy.data.dtos

import kotlinx.serialization.Serializable

@Serializable
data class YearlyConsumptionDTO(
    val date: String?,
    val power: Double?
)