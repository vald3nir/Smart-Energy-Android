package com.vald3nir.smart_energy.data.repository.remote.auth

import android.app.Activity
import com.vald3nir.smart_energy.data.dtos.GoogleUserDTO

interface AuthRepository {


    suspend fun authenticateWithGoogle(activity: Activity?)

    suspend fun loadUserGoogle(
        activity: Activity?,
        onSuccess: (user: GoogleUserDTO) -> Unit,
        onError: (() -> Unit)? = null
    )

}