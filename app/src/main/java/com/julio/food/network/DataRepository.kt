package com.julio.food.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object DataRepository {

    fun create(): APIService {
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://www.themealdb.com/api/json/v1/1/")
            .build()
        return retrofit.create(APIService::class.java)
    }
}