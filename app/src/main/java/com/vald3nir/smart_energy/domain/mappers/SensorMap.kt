package com.vald3nir.smart_energy.domain.mappers

import com.vald3nir.smart_energy.data.database.entities.SensorEntity
import com.vald3nir.smart_energy.data.dtos.SensorDTO
import com.vald3nir.smart_energy.data.dtos.ContractDTO


fun SensorEntity.asDTO() = SensorDTO(
    sensorId = sensorId,
    createdAt = createdAt,
    alias = alias,
)

fun SensorDTO.asEntity() = SensorEntity(
    sensorId = sensorId,
    createdAt = createdAt,
    alias = alias,
)

fun List<SensorEntity>.asDTO(): List<SensorDTO> = this.map { it.asDTO() }
fun List<SensorDTO>.asEntity(): List<SensorEntity> = this.map { it.asEntity() }

fun List<SensorDTO>.filterSensorsContracted(contractDTO: ContractDTO?): List<SensorDTO?> {
    val response = arrayListOf<SensorDTO?>()
    contractDTO?.items?.forEach { item ->
        response.add(this.find { it.sensorId == item.sensorId && item.active == true })
    }
    return response
}