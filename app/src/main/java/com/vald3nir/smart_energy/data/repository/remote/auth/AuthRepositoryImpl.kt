package com.vald3nir.smart_energy.data.repository.remote.auth

import android.app.Activity
import com.vald3nir.auth.google.GoogleSign
import com.vald3nir.auth.google.GoogleUserDTO
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor() : AuthRepository {

    override suspend fun authenticateWithGoogle(activity: Activity?) {
        GoogleSign.googleAuthenticate(activity)
    }

    override suspend fun loadUserGoogle(
        activity: Activity?,
        onSuccess: (user: GoogleUserDTO) -> Unit,
        onError: (() -> Unit)?
    ) {
        GoogleSign.loadUserGoogle(
            activity = activity,
            onSuccess = onSuccess,
            onError = onError
        )
    }
}