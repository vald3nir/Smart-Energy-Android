package com.vald3nir.commons.domain.use_cases

import android.app.Activity
import com.vald3nir.auth.google.GoogleUserDTO

interface AuthUseCase {
    fun loadUserGoogle(
        activity: Activity?,
        onSuccess: (user: GoogleUserDTO) -> Unit,
        onError: (() -> Unit)?
    )
}