package com.vald3nir.smart_energy.data.dtos

import com.vald3nir.core_repository.BaseDTO
import kotlinx.serialization.Serializable

@Serializable
data class AppPreferencesDTO(
    var useCompactDashboardCharts: Boolean = false,
    var useDemoMode: Boolean = false,
): BaseDTO()


