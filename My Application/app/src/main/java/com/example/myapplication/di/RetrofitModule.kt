package com.example.myapplication.di

import com.example.myapplication.MakeupRetrofit
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
object RetrofitModule {

    val BASE_URL = "https://makeup-api.herokuapp.com/api/v1/"

    //this will return the service api call that we can subscribe to
    @Singleton
    @JvmStatic
    @Provides
    fun makeupRetrofitObject() =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

    @Singleton
    @JvmStatic
    @Provides
    fun makeupRetrofitService(retrofit: Retrofit): MakeupRetrofit =
        retrofit.create(MakeupRetrofit::class.java)
}