package com.vald3nir.smart_energy.data.dtos

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ConsumptionRealTimeDTO(
    @SerialName("device_id")
    val deviceId: String?,
    val power: Double?
)