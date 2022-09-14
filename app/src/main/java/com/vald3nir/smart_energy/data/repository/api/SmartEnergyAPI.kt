package com.vald3nir.smart_energy.data.repository.api

import com.vald3nir.smart_energy.data.dtos.SensorDTO
import retrofit2.http.GET

interface SmartEnergyAPI {
    @GET(value = "sensors/list")
    suspend fun getSensors(): List<SensorDTO>

//    @GET(value = "/sensors/list/31f30d16-9729-11ec-ad33-a463a116a9e2")
//    suspend fun getSensor(): SensorDTO

}