package com.vald3nir.smart_energy.data.dtos

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DashboardDTO(
    val temperature: Double?,
    val humidity: Long?,
    val power: Double?,
    @SerialName("device_id") val deviceID: String?,
    @SerialName("created_at") val createdAt: String?
)