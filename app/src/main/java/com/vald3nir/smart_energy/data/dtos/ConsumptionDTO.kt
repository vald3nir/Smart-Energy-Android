package com.vald3nir.smart_energy.data.dtos

import kotlinx.serialization.Serializable

@Serializable
data class ConsumptionDTO(
    val date: String?,
    val power: Float?
)