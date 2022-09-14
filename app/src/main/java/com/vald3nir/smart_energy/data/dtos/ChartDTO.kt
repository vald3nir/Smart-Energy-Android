package com.vald3nir.smart_energy.data.dtos

data class ChartDTO(
    val labels: ArrayList<String> = arrayListOf(),
    val data: ArrayList<DataChartDTO> = arrayListOf(),
)

data class DataChartDTO(
    val label: String,
    val values: ArrayList<Float> = arrayListOf(),
)