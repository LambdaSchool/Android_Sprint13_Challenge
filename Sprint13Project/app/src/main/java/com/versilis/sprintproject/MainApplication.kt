package com.versilis.sprintproject

import android.app.Application
import com.versilis.sprintproject.di.DaggerMakeupNetworkComponent
import com.versilis.sprintproject.di.MakeupNetworkComponent
import com.versilis.sprintproject.di.MakeupNetworkModule

class MainApplication : Application() {

    lateinit var networkComponent: MakeupNetworkComponent
    override fun onCreate() {
        super.onCreate()

        networkComponent = DaggerMakeupNetworkComponent.builder()
            .makeupNetworkModule(MakeupNetworkModule)
            .build()
    }
}