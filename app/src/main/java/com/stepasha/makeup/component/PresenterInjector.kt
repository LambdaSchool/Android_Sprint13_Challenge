package com.stepasha.makeup.component

import com.stepasha.makeup.BaseView
import com.stepasha.makeup.module.ContextModule
import com.stepasha.makeup.module.NetworkModule
import com.stepasha.makeup.ui.makeup.PostPresenter
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [(ContextModule::class), (NetworkModule::class)])
interface PresenterInjector {

    fun inject(postPresenter: PostPresenter)

    @Component.Builder
    interface Builder {
        fun build(): PresenterInjector

        fun networkModule(networkModule: NetworkModule): Builder
        fun contextModule(contextModule: ContextModule): Builder

        @BindsInstance
        fun baseView(baseView: BaseView): Builder
    }



}