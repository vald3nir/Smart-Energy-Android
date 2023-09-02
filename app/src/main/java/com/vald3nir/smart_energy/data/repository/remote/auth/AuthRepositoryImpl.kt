package com.vald3nir.smart_energy.data.repository.remote.auth

import android.app.Activity
import com.vald3nir.auth.google.getGoogleUserLogger
import com.vald3nir.auth.google.googleSignIn
import com.vald3nir.smart_energy.data.dtos.GoogleUserDTO
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor() : AuthRepository {

    override suspend fun authenticateWithGoogle(activity: Activity?) {
        activity?.googleSignIn()
    }

    override suspend fun loadUserGoogle(
        activity: Activity?,
        onSuccess: (user: GoogleUserDTO) -> Unit,
        onError: (() -> Unit)?
    ) {
        val data = activity?.getGoogleUserLogger()
        if (data == null) {
            onError?.invoke()
        } else {
            onSuccess.invoke(
                GoogleUserDTO(
                    userName = data.displayName,
                    email = data.email,
                    profileImageUrl = data.photoUrl.toString()
                )
            )
        }
    }
}