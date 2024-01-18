package com.vald3nir.smart_energy.di

import com.vald3nir.commons.use_cases.AuthUseCase
import com.vald3nir.onboarding.domain.AuthUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class UseCasesModule {

//    @ViewModelScoped
//    @Binds
//    abstract fun bindPersistenceUseCase(
//        useCaseImpl: PersistenceUseCaseImpl,
//    ): PersistenceUseCase

    @ViewModelScoped
    @Binds
    abstract fun bindAuthUseCase(
        useCaseImpl: AuthUseCaseImpl,
    ): AuthUseCase

//    @ViewModelScoped
//    @Binds
//    abstract fun bindContractUseCase(
//        useCaseImpl: ContractUseCaseImpl,
//    ): ContractUseCase
//
//    @ViewModelScoped
//    @Binds
//    abstract fun bindSDashboardUseCase(
//        useCaseImpl: DashboardUseCaseImpl,
//    ): DashboardUseCase
//
//    @ViewModelScoped
//    @Binds
//    abstract fun bindSensorsUseCase(
//        useCaseImpl: SensorsUseCaseImpl,
//    ): SensorsUseCase
//
//    @ViewModelScoped
//    @Binds
//    abstract fun bindHistoricUseCase(
//        useCaseImpl: HistoricUseCaseImpl,
//    ): HistoricUseCase
//
//    @ViewModelScoped
//    @Binds
//    abstract fun bindAppPreferencesUseCase(
//        useCaseImpl: AppPreferencesUseCaseImpl,
//    ): AppPreferencesUseCase
}