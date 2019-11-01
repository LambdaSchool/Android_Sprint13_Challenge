package com.stepasha.makeupagain.di

import android.app.Application
import com.stepasha.makeupagain.SearchActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component (
    modules = [AppModule::class]
)
interface AppComponent {

    fun inject(mainActivity: SearchActivity)
}