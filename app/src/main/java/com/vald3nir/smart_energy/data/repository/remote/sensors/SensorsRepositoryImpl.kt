package com.vald3nir.smart_energy.data.repository.remote.sensors

import com.vald3nir.firebase_helpers.FirebaseDB
import com.vald3nir.firebase_helpers.extensions.parseStringListToObjects
import com.vald3nir.smart_energy.data.database.daos.SensorDAO
import com.vald3nir.smart_energy.data.dtos.ContractDTO
import com.vald3nir.smart_energy.data.dtos.SensorDTO
import com.vald3nir.smart_energy.data.repository.api.SmartEnergyAPI
import com.vald3nir.smart_energy.domain.mappers.asDTO
import com.vald3nir.smart_energy.domain.mappers.asEntity
import com.vald3nir.smart_energy.domain.mappers.filterSensorsContracted
import javax.inject.Inject

class SensorsRepositoryImpl @Inject constructor(
    private val sensorDAO: SensorDAO,
    private val api: SmartEnergyAPI
) : SensorsRepository {

    override suspend fun loadSensors(
        contractDTO: ContractDTO?,
        onSuccess: (List<SensorDTO?>) -> Unit,
        onError: ((Exception?) -> Unit)?
    ) {
        FirebaseDB.readList(
            path = "/release/sensor",
            onError = onError,
            onSuccess = {
                try {
                    val sensors: List<SensorDTO> = it.parseStringListToObjects()
                    onSuccess.invoke(sensors.filterSensorsContracted(contractDTO))
                } catch (e: Exception) {
                    onError?.invoke(e)
                }
            }
        )
//        try {
//            val data = api.getSensors()
//            onSuccess.invoke(data)
//        } catch (e: Exception) {
//            onError?.invoke(e)
//        }
    }

    override suspend fun updateSensorsLocal(
        sensors: List<SensorDTO>,
        onSuccess: () -> Unit,
        onError: ((Exception?) -> Unit)?
    ) {
        try {
            sensorDAO.clear()
            sensorDAO.insertSensors(sensors.asEntity())
            onSuccess.invoke()
        } catch (e: Exception) {
            onError?.invoke(e)
        }
    }

    override suspend fun loadSensorsLocal(
        onSuccess: (List<SensorDTO?>) -> Unit,
        onError: ((Exception?) -> Unit)?
    ) {
        try {
            onSuccess.invoke(sensorDAO.getSensors().asDTO())
        } catch (e: Exception) {
            onError?.invoke(e)
        }
    }

}