package com.vald3nir.smart_energy.data.repository.remote.dashboard

import com.google.gson.Gson
import com.vald3nir.core_repository.iot.MQTTClient
import com.vald3nir.smart_energy.data.dtos.DashboardDTO
import javax.inject.Inject

class DashboardRepositoryImpl @Inject constructor() : DashboardRepository {

    companion object {
        const val BROKEN_ADDRESS = "broker.hivemq.com"
    }

    private val clientMQTT = MQTTClient(BROKEN_ADDRESS)
    private val topics = setOf<String>()

    init {
        clientMQTT.connect()
    }

    override fun unsubscriberDashboardTopic() {
        topics.forEach { clientMQTT.unsubscribe(it) }
    }

    override suspend fun subscriberDashboardTopic(
        topic: String,
        onResponse: (dashboardDTO: DashboardDTO) -> Unit
    ) {
        topics.plus(topic)
        clientMQTT.subscribe(topic) { response ->
            try {
                if (response.isNotEmpty()) {
                    val dashboardDTO = Gson().fromJson(response, DashboardDTO::class.java)
                    onResponse.invoke(dashboardDTO)
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }


}