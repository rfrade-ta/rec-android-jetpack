package com.viator.android.rec.di

import androidx.appcompat.app.AppCompatActivity
import com.viator.android.rec.MainActivity
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object AppModule {

    @Provides
    @Singleton
    fun provideNavHostActivityClass(): Class<out AppCompatActivity> = MainActivity::class.java
}
