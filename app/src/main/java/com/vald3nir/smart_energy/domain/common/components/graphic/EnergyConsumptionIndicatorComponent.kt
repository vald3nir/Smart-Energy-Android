package com.vald3nir.smart_energy.domain.common.components.graphic

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import com.github.anastr.speedviewlib.components.Section
import com.vald3nir.smart_energy.R
import com.vald3nir.smart_energy.databinding.ComponentEnergyConsumptionIndicatorBinding
import com.vald3nir.smart_energy.domain.common.PERCENTAGE_MAX_VALUE_FOR_INTERMEDIARY_POWER_CONSUMPTION
import com.vald3nir.smart_energy.domain.common.PERCENTAGE_MAX_VALUE_FOR_NORMAL_POWER_CONSUMPTION

open class EnergyConsumptionIndicatorComponent : LinearLayoutCompat {

    private val binding by lazy {
        ComponentEnergyConsumptionIndicatorBinding.inflate(
            LayoutInflater.from(context),
            this,
            true
        )
    }

    init {
        orientation = VERTICAL
    }

    constructor(context: Context) : super(context) {
        initAttrs(null)
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        initAttrs(attrs)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context, attrs, defStyleAttr
    ) {
        initAttrs(attrs)
    }

    @SuppressLint("Recycle", "CustomViewStyleable")
    private fun initAttrs(attrs: AttributeSet?) = with(binding) {
        if (attrs == null) return
        val typedArray =
            context.obtainStyledAttributes(attrs, R.styleable.EnergyConsumptionIndicatorComponent)
        if (typedArray.getBoolean(
                R.styleable.EnergyConsumptionIndicatorComponent_viewCompact,
                false
            )
        ) {
            clGraphicSubtitle.isVisible = false
            val density = context.resources.displayMetrics.density
            val widthP = (130 * density).toInt()
            speedView.layoutParams = LinearLayout.LayoutParams(widthP, speedView.height)
        }
    }

    fun setLabelValues(maxValue: Int, textColorID: Int, sliceSize: Float) = with(binding.speedView) {
        val textColor = ContextCompat.getColor(context, textColorID)
        speedTextColor = textColor
        unitTextColor = textColor
        maxSpeed = maxValue.toFloat()
        clearSections()
        addSections(
            Section(
                0f,
                PERCENTAGE_MAX_VALUE_FOR_NORMAL_POWER_CONSUMPTION,
                Color.GREEN,
                dpTOpx(sliceSize)
            ),
            Section(
                PERCENTAGE_MAX_VALUE_FOR_NORMAL_POWER_CONSUMPTION,
                PERCENTAGE_MAX_VALUE_FOR_INTERMEDIARY_POWER_CONSUMPTION,
                Color.YELLOW,
                dpTOpx(sliceSize)
            ),
            Section(
                PERCENTAGE_MAX_VALUE_FOR_INTERMEDIARY_POWER_CONSUMPTION,
                1f,
                Color.RED,
                dpTOpx(sliceSize)
            )
        )
    }

    fun animateProgress(progress: Int) = with(binding.speedView) {
        speedTo(progress.toFloat())
    }
}