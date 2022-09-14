package com.vald3nir.smart_energy.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.vald3nir.smart_energy.data.database.utils.EntityConstant
import com.vald3nir.smart_energy.data.dtos.ContractItemDTO

@Entity(tableName = EntityConstant.CONTRACT_TABLE_NAME)
data class ContractEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0,
    var alias: String?,
    var clientId: String?,
    var createdAt: String?,
    var items: List<ContractItemDTO>?
)

