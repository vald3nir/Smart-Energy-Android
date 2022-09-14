package com.vald3nir.smart_energy.domain.use_cases.sensors

import com.vald3nir.smart_energy.data.dtos.SensorDTO
import com.vald3nir.smart_energy.data.repository.remote.sensors.SensorsRepository
import javax.inject.Inject

class SensorsUseCaseImpl @Inject constructor(
    private val repository: SensorsRepository
) : SensorsUseCase {

    override suspend fun loadSensors(
        onSuccess: (List<SensorDTO?>) -> Unit,
        onError: ((Exception?) -> Unit)?
    ) {
        repository.loadSensorsLocal(onSuccess, onError)
    }
}