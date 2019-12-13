package com.julio.food.model

import com.google.gson.annotations.SerializedName

data class Food(

    @SerializedName("strCategory")
    var name: String = "",

    @SerializedName("strCategoryDescription")
    var detail: String = "",

    @SerializedName("strCategoryThumb")
    var photo: String = ""
)

data class Categories(

    var categories: List<Food>
)