package com.vald3nir.smart_energy.domain.use_cases.dashboard

import android.content.Context
import com.vald3nir.smart_energy.data.dtos.DashboardDTO
import com.vald3nir.smart_energy.data.dtos.SensorDTO
import com.vald3nir.smart_energy.data.repository.remote.dashboard.DashboardRepository
import javax.inject.Inject

class DashboardUseCaseImpl @Inject constructor(
    private val repository: DashboardRepository
) : DashboardUseCase {

    companion object {
        const val BASE_TOPIC = "/smart_energy/consumption/client/"
    }

    override fun unsubscriberDashboardTopic() {
        repository.unsubscriberDashboardTopic()
    }

    override suspend fun subscriberDashboardTopic(
        context: Context?,
        sensor: SensorDTO,
        onResponse: (dashboardDTO: DashboardDTO) -> Unit
    ) {
        repository.subscriberDashboardTopic(
            topic = "${BASE_TOPIC}${sensor.sensorId}",
            onResponse = onResponse
        )
    }

}