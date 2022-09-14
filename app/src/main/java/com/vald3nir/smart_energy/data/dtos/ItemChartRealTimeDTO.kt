package com.vald3nir.smart_energy.data.dtos

import com.androidplot.pie.Segment
import com.androidplot.pie.SegmentFormatter

class ItemChartRealTimeDTO(
    val segment: Segment,
    val formatter: SegmentFormatter
)