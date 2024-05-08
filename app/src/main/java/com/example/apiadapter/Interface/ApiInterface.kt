package com.example.apiadapter.Interface

import com.example.apiadapter.api.MyData
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("products")
    fun getProductData():Call<MyData>
}