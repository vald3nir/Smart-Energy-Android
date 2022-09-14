package com.vald3nir.smart_energy.data.database.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.vald3nir.smart_energy.data.database.entities.HistoricEntity
import com.vald3nir.smart_energy.data.database.utils.EntityConstant.HISTORIC_TABLE_NAME

@Dao
interface HistoricDAO {

    @Query(value = "SELECT * FROM $HISTORIC_TABLE_NAME")
    fun getHistoric(): List<HistoricEntity>

    @Query("DELETE FROM $HISTORIC_TABLE_NAME")
    fun clear()

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertHistoric(entities: List<HistoricEntity>)

}