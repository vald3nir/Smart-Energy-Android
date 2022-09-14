package com.vald3nir.smart_energy.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.vald3nir.smart_energy.data.database.utils.EntityConstant.SENSOR_TABLE_NAME

@Entity(tableName = SENSOR_TABLE_NAME)
data class SensorEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0,
    var sensorId: String?,
    var createdAt: String?,
    var alias: String?
)



