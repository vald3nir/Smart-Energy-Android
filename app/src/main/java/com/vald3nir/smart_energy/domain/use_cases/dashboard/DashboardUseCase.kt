package com.vald3nir.smart_energy.domain.use_cases.dashboard

import android.content.Context
import com.vald3nir.smart_energy.data.dtos.DashboardDTO
import com.vald3nir.smart_energy.data.dtos.SensorDTO

interface DashboardUseCase {

    fun unsubscriberDashboardTopic()

    suspend fun subscriberDashboardTopic(
        context: Context?,
        sensor: SensorDTO,
        onResponse: (dashboardDTO: DashboardDTO) -> Unit
    )
}