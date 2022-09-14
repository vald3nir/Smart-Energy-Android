package com.vald3nir.smart_energy.domain.use_cases.sensors

import com.vald3nir.smart_energy.data.dtos.SensorDTO

interface SensorsUseCase {

    suspend fun loadSensors(
        onSuccess: (List<SensorDTO?>) -> Unit,
        onError: ((Exception?) -> Unit)? = null
    )

}