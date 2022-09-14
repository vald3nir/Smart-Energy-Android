package com.vald3nir.smart_energy.di

import android.content.Context
import androidx.room.Room
import com.vald3nir.smart_energy.data.database.AppDatabase
import com.vald3nir.smart_energy.data.database.daos.ContractDAO
import com.vald3nir.smart_energy.data.database.daos.HistoricDAO
import com.vald3nir.smart_energy.data.database.daos.SensorDAO
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun providesDatabase(
        @ApplicationContext appContext: Context,
    ): AppDatabase = Room
        .databaseBuilder(appContext, AppDatabase::class.java, "database.db")
        .fallbackToDestructiveMigration()
        .allowMainThreadQueries()
        .build()


    @Provides
    @Singleton
    fun providesSensorDAO(
        database: AppDatabase,
    ): SensorDAO = database.sensorDAO()

    @Provides
    @Singleton
    fun providesHistoricDAO(
        database: AppDatabase,
    ): HistoricDAO = database.historicDAO()

    @Provides
    @Singleton
    fun providesContractDAO(
        database: AppDatabase,
    ): ContractDAO = database.contractDAO()
}

