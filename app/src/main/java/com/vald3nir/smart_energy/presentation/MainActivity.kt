package com.vald3nir.smart_energy.presentation

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.vald3nir.commons.databinding.ActivityEmptyBinding
import com.vald3nir.commons.views.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityEmptyBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        setupUIStateObserver(viewModel)
        viewModel.startFlows(this)
    }
}