package com.stepasha.makeupagain

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.stepasha.makeupagain.di.AppComponent
import com.stepasha.makeupagain.di.DaggerAppComponent


class App: Application() {

    val appComponent by lazy {
        DaggerAppComponent
            .builder()
            .build()
    }
}