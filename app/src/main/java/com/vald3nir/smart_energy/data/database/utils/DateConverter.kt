package com.vald3nir.smart_energy.data.database.utils

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.vald3nir.smart_energy.data.dtos.ConsumptionDTO
import com.vald3nir.smart_energy.data.dtos.ContractItemDTO

class DateConverter {

    @TypeConverter
    fun listConsumptionDTOToJson(value: List<ConsumptionDTO>?): String? = Gson().toJson(value)

    @TypeConverter
    fun jsonToListConsumptionDTO(value: String) =
        Gson().fromJson(value, Array<ConsumptionDTO>::class.java).toList()

    @TypeConverter
    fun listContractItemToJson(value: List<ContractItemDTO>?): String? = Gson().toJson(value)

    @TypeConverter
    fun jsonToListContractItem(value: String) =
        Gson().fromJson(value, Array<ContractItemDTO>::class.java).toList()

}
