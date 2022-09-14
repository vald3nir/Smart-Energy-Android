package com.vald3nir.smart_energy.data.dtos

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SensorDTO(
    val alias: String?,
    @SerialName("sensor_id") val sensorId: String?,
    @SerialName("created_at") val createdAt: String?,
)