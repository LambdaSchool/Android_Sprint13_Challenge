package com.stepasha.makeupagain.retrofit


import com.stepasha.makeupagain.model.MakeupItem
import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.*

interface ApiCall {

    @GET("products.json")
    fun getMakeup(@Query("brand") brand: String): Single<Array<MakeupItem>>
}