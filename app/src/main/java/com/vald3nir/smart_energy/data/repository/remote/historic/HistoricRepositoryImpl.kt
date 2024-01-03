package com.vald3nir.smart_energy.data.repository.remote.historic

import com.vald3nir.firebase_helpers.FirebaseDB
import com.vald3nir.firebase_helpers.extensions.parseStringListToObjects
import com.vald3nir.smart_energy.data.database.daos.HistoricDAO
import com.vald3nir.smart_energy.data.dtos.HistoricDTO
import com.vald3nir.smart_energy.domain.mappers.asDTO
import com.vald3nir.smart_energy.domain.mappers.asEntity
import com.vald3nir.smart_energy.domain.utils.parseEmailToKey
import javax.inject.Inject

class HistoricRepositoryImpl @Inject constructor(
    private val historicDAO: HistoricDAO
) : HistoricRepository {

    override suspend fun loadHistoric(
        email: String,
        onSuccess: (List<HistoricDTO>) -> Unit,
        onError: ((Exception?) -> Unit)?
    ) {
        val key = email.parseEmailToKey()
        FirebaseDB.readList(
            path = "/release/historic/${key}",
            onError = onError,
            onSuccess = {
                val response: List<HistoricDTO> = it.parseStringListToObjects()
                onSuccess.invoke(response)
            },
        )
    }

    override suspend fun loadHistoricLocal(
        onSuccess: (List<HistoricDTO>) -> Unit,
        onError: ((e: Exception) -> Unit)?
    ) {
        try {
            onSuccess.invoke(historicDAO.getHistoric().asDTO())
        } catch (e: Exception) {
            onError?.invoke(e)
        }
    }

    override suspend fun updateHistoricLocal(
        historic: List<HistoricDTO>,
        onSuccess: () -> Unit,
        onError: ((Exception?) -> Unit)?
    ) {
        try {
            historicDAO.clear()
            historicDAO.insertHistoric(historic.asEntity())
            onSuccess.invoke()
        } catch (e: Exception) {
            onError?.invoke(e)
        }
    }

}