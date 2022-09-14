package com.vald3nir.smart_energy.data.database.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.vald3nir.smart_energy.data.database.entities.SensorEntity
import com.vald3nir.smart_energy.data.database.utils.EntityConstant.SENSOR_TABLE_NAME

@Dao
interface SensorDAO {

    @Query(value = "SELECT * FROM $SENSOR_TABLE_NAME")
    fun getSensors(): List<SensorEntity>


    @Query("DELETE FROM $SENSOR_TABLE_NAME")
    fun clear()


    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertSensors(entities: List<SensorEntity>)

}