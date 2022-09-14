package com.vald3nir.smart_energy.data.repository.remote.dashboard

import com.vald3nir.smart_energy.data.dtos.DashboardDTO

interface DashboardRepository {

    fun unsubscriberDashboardTopic()

    suspend fun subscriberDashboardTopic(
        topic: String,
        onResponse: (dashboardDTO: DashboardDTO) -> Unit
    )

}