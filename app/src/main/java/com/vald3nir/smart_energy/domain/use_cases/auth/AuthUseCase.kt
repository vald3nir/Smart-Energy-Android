package com.vald3nir.smart_energy.domain.use_cases.auth

import android.app.Activity
import com.vald3nir.smart_energy.data.dtos.GoogleUserDTO

interface AuthUseCase {

    suspend fun authenticateWithGoogle(activity: Activity?)

    suspend fun loadUserGoogle(
        activity: Activity?,
        onSuccess: (user: GoogleUserDTO) -> Unit,
        onError: (() -> Unit)? = null
    )
}