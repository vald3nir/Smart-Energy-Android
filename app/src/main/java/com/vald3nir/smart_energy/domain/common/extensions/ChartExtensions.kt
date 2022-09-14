package com.vald3nir.smart_energy.domain.common.extensions

import android.content.Context
import android.graphics.Color
import android.graphics.DashPathEffect
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet
import com.vald3nir.smart_energy.R
import ir.mahozad.android.PieChart

const val MAX_VALUE_POWER_CONSUMPTION = 2000
const val MEDIA_VALUE_POWER_CONSUMPTION = 300
const val INTERMEDIARY_VALUE_POWER_CONSUMPTION = 450


fun getColorPowerValue(power: Double): Int {
    return when {
        power <= MEDIA_VALUE_POWER_CONSUMPTION -> Color.GREEN
        power <= INTERMEDIARY_VALUE_POWER_CONSUMPTION -> Color.YELLOW
        else -> Color.RED
    }
}

fun getPowerStatus(context: Context, power: Double): String {
    return when {
        power <= MEDIA_VALUE_POWER_CONSUMPTION -> context.getString(R.string.normal)
        power <= INTERMEDIARY_VALUE_POWER_CONSUMPTION -> context.getString(R.string.moderate)
        else -> context.getString(R.string.high)
    }
}

//fun LineChart.setup(context: Context, values: ArrayList<Entry>) {
//    val markerView = CustomMarkerView(context, R.layout.custom_marker_view)
//    markerView.chartView = this
//    marker = markerView
//    legend.form = Legend.LegendForm.NONE
//    setBackgroundColor(Color.BLACK)
//    description.isEnabled = false
//    setTouchEnabled(true)
//    setDrawGridBackground(false)
//    isDragEnabled = true
//    setScaleEnabled(true)
//    setPinchZoom(true)
//    animateX(1500)
//    fillData(values)
//}

private fun LineChart.fillData(values: ArrayList<Entry>) {
    val lineDataSet = LineDataSet(values, "")
    lineDataSet.color = Color.YELLOW
    lineDataSet.setCircleColor(Color.YELLOW)
    lineDataSet.valueTextColor = Color.YELLOW
    lineDataSet.fillColor = Color.GREEN
    lineDataSet.lineWidth = 1f
    lineDataSet.circleRadius = 3f
    lineDataSet.setDrawCircleHole(false)
    lineDataSet.formLineWidth = 1f
    lineDataSet.formLineDashEffect = DashPathEffect(floatArrayOf(10f, 5f), 0f)
    lineDataSet.formSize = 15f
    lineDataSet.valueTextSize = 9f
    lineDataSet.enableDashedHighlightLine(10f, 5f, 0f)
    lineDataSet.setDrawFilled(true)

    val dataSets = ArrayList<ILineDataSet>()
    dataSets.add(lineDataSet)
    data = LineData(dataSets)
}


fun PieChart.loadData(power: Double?, MAX: Int = 1000) {
    if (power == null) return
    slices = if (power >= MAX) {
        listOf(PieChart.Slice(1.0f, Color.RED))
    } else {
        val used = (power / MAX).toFloat()
        val notUsed = 1 - used
        listOf(
            createMark(power, used),
            PieChart.Slice(notUsed, Color.BLACK),
        )
    }
}

fun createMark(power: Double, frac: Float): PieChart.Slice {
    if (power <= 0) return PieChart.Slice(frac, Color.BLACK)
    if (power <= 300) return PieChart.Slice(frac, Color.GREEN)
    if (power <= 500) return PieChart.Slice(frac, Color.YELLOW)
    return PieChart.Slice(frac, Color.RED)

}


//fun BarChart.setup() {
//
//    description.isEnabled = false
//    legend.form = Legend.LegendForm.NONE
//
//    setOnChartValueSelectedListener(object : OnChartValueSelectedListener {
//
//        override fun onValueSelected(e: Entry?, h: Highlight?) {
//            Toast.makeText(context, "${e?.x} - ${e?.y}", Toast.LENGTH_SHORT).show()
//        }
//
//        override fun onNothingSelected() {
//        }
//
//    })
//
//    setDrawBarShadow(false)
//    setDrawValueAboveBar(true)
//    setMaxVisibleValueCount(60)
//    setPinchZoom(false)
//    setDrawGridBackground(false)
//
//    xAxis.apply {
//        textColor = Color.WHITE
//        position = XAxis.XAxisPosition.BOTTOM
//        setDrawGridLines(false)
//        granularity = 1f // only intervals of 1 day
//        valueFormatter = DayAxisValueFormatter()
//    }
//
//    axisRight.apply {
//        setDrawGridLines(false)
//        textColor = Color.WHITE
//        setLabelCount(8, false)
//        spaceTop = 15f
//        axisMinimum = 0f
//    }
//
//
//    val start = 1f
//    val values = ArrayList<BarEntry>()
//    var i = start.toInt()
//
//    while (i < start + 12) {
//        values.add(BarEntry(i.toFloat(), (i * 10).toFloat()))
//        i++
//    }
//    xAxis.labelCount = 12
//
//    if (data != null && data.dataSetCount > 0
//    ) {
//        val set1: BarDataSet = data.getDataSetByIndex(0) as BarDataSet
//        set1.values = values
//        data.notifyDataChanged()
//        notifyDataSetChanged()
//        invalidate()
//
//    } else {
//        val set1 = BarDataSet(values, "The year 2017")
//        set1.setDrawIcons(false)
//        val dataSets = ArrayList<IBarDataSet>()
//        dataSets.add(set1)
//        val barData = BarData(dataSets)
//        barData.setValueTextSize(10f)
//        barData.barWidth = 0.9f
//        data = barData
//    }
//}