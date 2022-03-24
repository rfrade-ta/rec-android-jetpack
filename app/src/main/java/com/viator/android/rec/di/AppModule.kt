package com.viator.android.rec.di

import com.viator.android.rec.data.api.StarWarsService
import com.viator.android.rec.data.datasource.StarWarsDataSource
import com.viator.android.rec.data.datasource.StarWarsDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object AppModule {

    @Singleton
    @Provides
    fun provideStarWarsService(): StarWarsService {
        return StarWarsService.create()
    }

    @Singleton
    @Provides
    fun provideStarWarsDataSource(
        starWarsService: StarWarsService
    ): StarWarsDataSource {
        return StarWarsDataSourceImpl(starWarsService)
    }
}
