package com.vald3nir.smart_energy.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.vald3nir.smart_energy.data.database.daos.ContractDAO
import com.vald3nir.smart_energy.data.database.daos.HistoricDAO
import com.vald3nir.smart_energy.data.database.daos.SensorDAO
import com.vald3nir.smart_energy.data.database.entities.ContractEntity
import com.vald3nir.smart_energy.data.database.entities.HistoricEntity
import com.vald3nir.smart_energy.data.database.entities.SensorEntity
import com.vald3nir.smart_energy.data.database.utils.DateConverter

@Database(
    version = 1,
    exportSchema = true,
    entities = [
        ContractEntity::class,
        SensorEntity::class,
        HistoricEntity::class
    ],
)
@TypeConverters(DateConverter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun sensorDAO(): SensorDAO
    abstract fun historicDAO(): HistoricDAO
    abstract fun contractDAO(): ContractDAO
}