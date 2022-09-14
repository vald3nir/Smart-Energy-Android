package com.vald3nir.smart_energy.di

import com.vald3nir.smart_energy.domain.use_cases.app_preferences.AppPreferencesUseCase
import com.vald3nir.smart_energy.domain.use_cases.app_preferences.AppPreferencesUseCaseImpl
import com.vald3nir.smart_energy.domain.use_cases.auth.AuthUseCase
import com.vald3nir.smart_energy.domain.use_cases.auth.AuthUseCaseImpl
import com.vald3nir.smart_energy.domain.use_cases.contract.ContractUseCase
import com.vald3nir.smart_energy.domain.use_cases.contract.ContractUseCaseImpl
import com.vald3nir.smart_energy.domain.use_cases.dashboard.DashboardUseCase
import com.vald3nir.smart_energy.domain.use_cases.dashboard.DashboardUseCaseImpl
import com.vald3nir.smart_energy.domain.use_cases.historic.HistoricUseCase
import com.vald3nir.smart_energy.domain.use_cases.historic.HistoricUseCaseImpl
import com.vald3nir.smart_energy.domain.use_cases.persistence.PersistenceUseCase
import com.vald3nir.smart_energy.domain.use_cases.persistence.PersistenceUseCaseImpl
import com.vald3nir.smart_energy.domain.use_cases.sensors.SensorsUseCase
import com.vald3nir.smart_energy.domain.use_cases.sensors.SensorsUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class UseCasesModule {

    @ViewModelScoped
    @Binds
    abstract fun bindPersistenceUseCase(
        useCaseImpl: PersistenceUseCaseImpl,
    ): PersistenceUseCase

    @ViewModelScoped
    @Binds
    abstract fun bindAuthUseCase(
        useCaseImpl: AuthUseCaseImpl,
    ): AuthUseCase

    @ViewModelScoped
    @Binds
    abstract fun bindContractUseCase(
        useCaseImpl: ContractUseCaseImpl,
    ): ContractUseCase

    @ViewModelScoped
    @Binds
    abstract fun bindSDashboardUseCase(
        useCaseImpl: DashboardUseCaseImpl,
    ): DashboardUseCase

    @ViewModelScoped
    @Binds
    abstract fun bindSensorsUseCase(
        useCaseImpl: SensorsUseCaseImpl,
    ): SensorsUseCase

    @ViewModelScoped
    @Binds
    abstract fun bindHistoricUseCase(
        useCaseImpl: HistoricUseCaseImpl,
    ): HistoricUseCase

    @ViewModelScoped
    @Binds
    abstract fun bindAppPreferencesUseCase(
        useCaseImpl: AppPreferencesUseCaseImpl,
    ): AppPreferencesUseCase
}