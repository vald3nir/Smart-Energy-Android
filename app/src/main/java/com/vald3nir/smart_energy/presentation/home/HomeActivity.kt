package com.vald3nir.smart_energy.presentation.home

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.vald3nir.smart_energy.databinding.ActivityHomeBinding
import com.vald3nir.smart_energy.domain.common.view.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val viewModel = ViewModelProvider(this)[HomeViewModel::class.java]
        setupUIStateObserver(viewModel)
    }

}

fun Activity.redirectToHome() {
    val newIntent = Intent(this, HomeActivity::class.java)
    newIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
    startActivity(newIntent)
}