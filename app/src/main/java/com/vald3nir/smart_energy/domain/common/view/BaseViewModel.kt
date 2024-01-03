package com.vald3nir.smart_energy.domain.common.view

import androidx.lifecycle.viewModelScope
import com.vald3nir.core.presentation.CoreViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

open class BaseViewModel : CoreViewModel() {
    fun runOnMainThread(call: () -> Unit) {
        viewModelScope.launch(Dispatchers.Main) {
            call.invoke()
        }
    }
}