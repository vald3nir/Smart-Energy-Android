package com.vald3nir.smart_energy

import android.os.Bundle
import com.vald3nir.commons.databinding.ActivityEmptyBinding
import com.vald3nir.commons.views.BaseActivity

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityEmptyBinding.inflate(layoutInflater)
        setContentView(binding.root)
        showLoading(true)
    }
}