package com.versilis.sprintproject.di

import com.versilis.sprintproject.data.remote.MakeupApiProvider
import com.versilis.sprintproject.data.remote.MakeupApiService
import dagger.Module
import dagger.Provides

@Module
object MakeupNetworkModule {
    @Provides
    fun provideService(): MakeupApiService = MakeupApiProvider().getMakeupService()
}