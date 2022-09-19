package com.example.love_calculatorjusup.Retrofit

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface LoveApi {
    @GET("getPercentage")
    fun getCalculateLove(
        @Query("fname") firstName: String,
        @Query("sname") second: String,
        @Header("X-RapidAPI-Key") key: String = "ea0ba7d6cemshf7221a4478360a6p13c847jsn9b9cbf6d8973",
        @Header("X-RapidAPI-Host") host: String = "love-calculator.p.rapidapi.com"
    ): Call<LoveModel>
}