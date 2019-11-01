package com.example.myapplication

import android.app.Application
import com.example.myapplication.di.AppComponent
import com.example.myapplication.di.DaggerAppComponent
import com.example.myapplication.di.RetrofitModule

class App: Application() {

    companion object {
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()

        initDI()
    }

    private fun initDI() {
        appComponent = DaggerAppComponent.builder()
            .retrofitModule(RetrofitModule)
            .build()
    }
}