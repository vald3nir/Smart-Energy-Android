package com.vald3nir.smart_energy.data.dtos

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ContractDTO(
    val alias: String?,
    @SerialName("client_id") val clientId: String?,
    @SerialName("created_at") val createdAt: String?,
    val items: List<ContractItemDTO>?
)

@Serializable
data class ContractItemDTO(
    val active: Boolean?,
    @SerialName("sensor_id") val sensorId: String?,
    @SerialName("address_id") val addressId: String?,
)