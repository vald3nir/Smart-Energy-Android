package com.vald3nir.smart_energy.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.vald3nir.smart_energy.data.database.utils.EntityConstant
import com.vald3nir.smart_energy.data.dtos.ConsumptionDTO

@Entity(tableName = EntityConstant.HISTORIC_TABLE_NAME)
data class HistoricEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0,
    var sensorAlias: String?,
    var consumptionDays: List<ConsumptionDTO>,
    var consumptionHours: List<ConsumptionDTO>,
    var consumptionMonths: List<ConsumptionDTO>,
    var consumptionYears: List<ConsumptionDTO>,
)