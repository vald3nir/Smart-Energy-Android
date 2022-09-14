package com.vald3nir.smart_energy.data.database.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.vald3nir.smart_energy.data.database.entities.ContractEntity
import com.vald3nir.smart_energy.data.database.utils.EntityConstant.CONTRACT_TABLE_NAME

@Dao
interface ContractDAO {

    @Query(value = "SELECT * FROM $CONTRACT_TABLE_NAME")
    fun getContract(): ContractEntity

    @Query("DELETE FROM $CONTRACT_TABLE_NAME")
    fun clear()

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertContract(entity: ContractEntity?)

}