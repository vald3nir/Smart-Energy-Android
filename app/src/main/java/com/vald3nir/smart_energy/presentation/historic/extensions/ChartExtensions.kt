package com.vald3nir.smart_energy.presentation.historic.extensions

import com.github.aachartmodel.aainfographics.aachartcreator.AAChartAnimationType
import com.github.aachartmodel.aainfographics.aachartcreator.AAChartModel
import com.github.aachartmodel.aainfographics.aachartcreator.AAChartType
import com.github.aachartmodel.aainfographics.aachartcreator.AAChartView
import com.github.aachartmodel.aainfographics.aachartcreator.AASeriesElement
import com.github.aachartmodel.aainfographics.aaoptionsmodel.AAStyle
import com.vald3nir.smart_energy.R
import com.vald3nir.smart_energy.data.dtos.ChartDTO
import com.vald3nir.smart_energy.data.dtos.DataChartDTO

fun AAChartView.setup(title: String, dto: ChartDTO, type: AAChartType) {

    val textStyle = AAStyle()
    textStyle.color = "#ffffff"

    val aaChartModel: AAChartModel = AAChartModel()
        .chartType(type)
        .title(title).titleStyle(textStyle)
        //.subtitle("subtitle").subtitleStyle(textStyle)
        .axesTextColor("#d0a849")
        .yAxisTitle("Potencia KW/h")
        .backgroundColor(R.color.main_color)
        .dataLabelsEnabled(false)
        .legendEnabled(dto.data.size > 1) // seleção de grafico
        .animationType(AAChartAnimationType.EaseInCubic)
        .animationDuration(1200)
        .categories(dto.labels.toTypedArray())
        .series(dto.data.format())
    aa_drawChartWithChartModel(aaChartModel)
}

fun ArrayList<DataChartDTO>.format(): Array<Any> {
    val items: ArrayList<AASeriesElement> = arrayListOf()
    this.forEach {
        items.add(AASeriesElement().name(it.label).data(it.values.toTypedArray()))
    }
    return items.toTypedArray()
}