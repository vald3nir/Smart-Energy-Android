package com.vald3nir.onboarding.di

import com.vald3nir.commons.domain.use_cases.AuthUseCase
import com.vald3nir.onboarding.domain.AuthUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class OnboardingModule {
    @ViewModelScoped
    @Binds
    abstract fun bindAuthUseCase(
        useCaseImpl: AuthUseCaseImpl,
    ): AuthUseCase
}