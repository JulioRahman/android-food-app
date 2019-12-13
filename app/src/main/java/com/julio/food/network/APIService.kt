package com.julio.food.network

import com.julio.food.model.Categories
import retrofit2.Call
import retrofit2.http.GET

interface APIService {

    @GET("categories.php")
    fun getCategory(): Call<Categories>
}