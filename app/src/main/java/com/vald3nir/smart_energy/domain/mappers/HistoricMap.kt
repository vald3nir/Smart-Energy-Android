package com.vald3nir.smart_energy.domain.mappers

import com.vald3nir.smart_energy.data.database.entities.HistoricEntity
import com.vald3nir.smart_energy.data.dtos.HistoricDTO

fun HistoricEntity.asDTO() = HistoricDTO(
    sensorAlias = sensorAlias,
    consumptionDays = consumptionDays,
    consumptionHours = consumptionHours,
    consumptionMonths = consumptionMonths,
    consumptionYears = consumptionYears
)

fun HistoricDTO.asModel() = HistoricEntity(
    sensorAlias = sensorAlias,
    consumptionDays = consumptionDays,
    consumptionHours = consumptionHours,
    consumptionMonths = consumptionMonths,
    consumptionYears = consumptionYears
)

fun List<HistoricEntity>.asDTO(): List<HistoricDTO> = this.map { it.asDTO() }
fun List<HistoricDTO>.asEntity(): List<HistoricEntity> = this.map { it.asModel() }