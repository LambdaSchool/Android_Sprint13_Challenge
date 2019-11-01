package com.stepasha.makeup.network

import com.stepasha.makeup.model.MakeupItem
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiCall {
    @GET("api/v1/products.json")
    fun getMakeup(@Query("query")query: String): Observable<List<MakeupItem>>
}