package com.vald3nir.smart_energy.presentation.historic

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.vald3nir.extensions.parcelable
import com.vald3nir.smart_energy.data.dtos.GoogleUserDTO
import com.vald3nir.smart_energy.databinding.ActivityHistoricBinding
import com.vald3nir.smart_energy.domain.common.view.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HistoricActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityHistoricBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}

private const val USER_PARAM = "USER_PARAM"

fun Activity.redirectToHistoric(userLogged: GoogleUserDTO?) {
    val intent = Intent(this, HistoricActivity::class.java)
    intent.putExtra(USER_PARAM, userLogged)
    startActivity(intent)
}

fun Activity.getUserLogged(): GoogleUserDTO? {
    return intent.parcelable(USER_PARAM)
}
