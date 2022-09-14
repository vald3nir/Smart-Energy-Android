package com.vald3nir.smart_energy.data.repository.remote.sensors

import com.vald3nir.smart_energy.data.dtos.SensorDTO
import com.vald3nir.smart_energy.data.dtos.ContractDTO

interface SensorsRepository {

    suspend fun loadSensors(
        contractDTO: ContractDTO?,
        onSuccess: (List<SensorDTO?>) -> Unit,
        onError: ((Exception?) -> Unit)? = null
    )

    suspend fun updateSensorsLocal(
        sensors: List<SensorDTO>,
        onSuccess: () -> Unit,
        onError: ((Exception?) -> Unit)? = null
    )

    suspend fun loadSensorsLocal(
        onSuccess: (List<SensorDTO?>) -> Unit,
        onError: ((Exception?) -> Unit)? = null
    )

}