package com.vald3nir.smart_energy.di

import com.vald3nir.smart_energy.data.repository.remote.auth.AuthRepository
import com.vald3nir.smart_energy.data.repository.remote.auth.AuthRepositoryImpl
import com.vald3nir.smart_energy.data.repository.remote.contract.ContractRepository
import com.vald3nir.smart_energy.data.repository.remote.contract.ContractRepositoryImpl
import com.vald3nir.smart_energy.data.repository.remote.dashboard.DashboardRepository
import com.vald3nir.smart_energy.data.repository.remote.dashboard.DashboardRepositoryImpl
import com.vald3nir.smart_energy.data.repository.remote.historic.HistoricRepository
import com.vald3nir.smart_energy.data.repository.remote.historic.HistoricRepositoryImpl
import com.vald3nir.smart_energy.data.repository.remote.preferences.AppPreferencesRepository
import com.vald3nir.smart_energy.data.repository.remote.preferences.AppPreferencesRepositoryImpl
import com.vald3nir.smart_energy.data.repository.remote.sensors.SensorsRepository
import com.vald3nir.smart_energy.data.repository.remote.sensors.SensorsRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule {

    @ViewModelScoped
    @Binds
    abstract fun bindAuthRepository(
        repositoryImpl: AuthRepositoryImpl,
    ): AuthRepository

    @ViewModelScoped
    @Binds
    abstract fun bindContractRepository(
        repositoryImpl: ContractRepositoryImpl,
    ): ContractRepository

    @ViewModelScoped
    @Binds
    abstract fun bindDashboardRepository(
        repositoryImpl: DashboardRepositoryImpl,
    ): DashboardRepository

    @ViewModelScoped
    @Binds
    abstract fun bindHistoricRepository(
        repositoryImpl: HistoricRepositoryImpl,
    ): HistoricRepository

    @ViewModelScoped
    @Binds
    abstract fun bindAppPreferencesRepository(
        repositoryImpl: AppPreferencesRepositoryImpl,
    ): AppPreferencesRepository

    @ViewModelScoped
    @Binds
    abstract fun bindSensorsRepository(
        repositoryImpl: SensorsRepositoryImpl,
    ): SensorsRepository
}