package com.example.love_calculatorjusup.Retrofit

import com.example.love_calculatorjusup.Retrofit.LoveApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class RetrofitService {
   private val retrofit = Retrofit.Builder().baseUrl("https://love-calculator.p.rapidapi.com/").addConverterFactory(
      GsonConverterFactory.create()).build()

   val api = retrofit.create<LoveApi>()




}