package com.vald3nir.smart_energy.di

import com.vald3nir.commons.domain.AppNavigator
import com.vald3nir.smart_energy.domain.AppNavigatorImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class ApplicationModule {

    @ViewModelScoped
    @Binds
    abstract fun bindAppNavigator(impl: AppNavigatorImpl): AppNavigator

}