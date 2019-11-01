package com.example.myapplication

import com.example.myapplication.models.MakeupProduct
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface MakeupRetrofit {

    @GET("products.json")
    fun getMakeUpProductsByBrand(@Query("brand") brand: String): Observable<List<MakeupProduct>>

}