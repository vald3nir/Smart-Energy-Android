package com.vald3nir.smart_energy.domain.use_cases.auth

import android.app.Activity
import com.vald3nir.auth.google.GoogleUserDTO
import com.vald3nir.smart_energy.data.repository.remote.auth.AuthRepository
import javax.inject.Inject

class AuthUseCaseImpl @Inject constructor(
    private val repository: AuthRepository
) : AuthUseCase {


    override suspend fun authenticateWithGoogle(activity: Activity?) {
        repository.authenticateWithGoogle(activity)
    }

    override suspend fun loadUserGoogle(
        activity: Activity?,
        onSuccess: (user: GoogleUserDTO) -> Unit,
        onError: (() -> Unit)?
    ) {
        repository.loadUserGoogle(activity, onSuccess, onError)
    }
}