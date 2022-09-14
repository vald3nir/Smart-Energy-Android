package com.vald3nir.smart_energy.data.repository.fake

import com.vald3nir.smart_energy.data.dtos.DashboardDTO
import java.util.Random


fun IntRange.random() = Random().nextInt((endInclusive + 1) - start) + start

class FakeMQTT(
    private val onResponse: (dashboardDTO: DashboardDTO) -> Unit
) : Thread() {


    override fun run() {
        super.run()
        while (true) {
            onResponse.invoke(
                DashboardDTO(
                    temperature = (28..32).random().toDouble(),
                    humidity = (70..72).random().toLong(),
                    power = 750.0,
//                    power = (150..1000).random().toDouble(),
                    deviceID = null,
                    createdAt = null,
                )
            )
            sleep(2000)
        }
    }
}


class DashboardDataFake {

    suspend fun subscriberDashboardTopic(
        onResponse: (dashboardDTO: DashboardDTO) -> Unit
    ) {
        FakeMQTT(onResponse).start()
    }

}