package com.vald3nir.onboarding.domain

import android.app.Activity
import com.vald3nir.auth.google.GoogleSign
import com.vald3nir.auth.google.GoogleUserDTO
import com.vald3nir.commons.use_cases.AuthUseCase
import javax.inject.Inject

class AuthUseCaseImpl @Inject constructor() : AuthUseCase {
    override fun loadUserGoogle(
        activity: Activity?,
        onSuccess: (user: GoogleUserDTO) -> Unit,
        onError: () -> Unit
    ) {
        GoogleSign.loadUserGoogle(
            activity = activity,
            onError = onError,
            onSuccess = onSuccess
        )
    }
}