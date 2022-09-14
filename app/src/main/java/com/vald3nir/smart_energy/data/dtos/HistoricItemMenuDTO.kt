package com.vald3nir.smart_energy.data.dtos

data class HistoricItemMenuDTO(
    val icon: Int,
    val title: Int,
    val item: ItemMenuEnum
)

enum class ItemMenuEnum {
    LAST_HOURS, SELECTED_DAY, LAST_DAYS, LAST_MONTHS, ENVIRONMENT, SOLAR_GENERATION
}