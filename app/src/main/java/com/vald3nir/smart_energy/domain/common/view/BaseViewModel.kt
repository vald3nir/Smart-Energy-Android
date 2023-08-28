package com.vald3nir.smart_energy.domain.common.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

open class BaseViewModel : ViewModel() {
    fun runOnMainThread(call: () -> Unit) {
        viewModelScope.launch(Dispatchers.Main) {
            call.invoke()
        }
    }
}