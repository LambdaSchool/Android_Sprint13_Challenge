package com.versilis.sprintproject.di

import com.versilis.sprintproject.ui.MakeupListActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [MakeupNetworkModule::class])
interface MakeupNetworkComponent {
    fun inject(makeupListActivity: MakeupListActivity)
}