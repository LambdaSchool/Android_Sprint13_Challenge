package com.example.myapplication.di

import com.example.myapplication.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules =
            [RetrofitModule::class])
interface AppComponent {

    fun inject(mainActivity: MainActivity)
}