package com.bekiraydemir.letsactivity.retrofit

import com.google.gson.annotations.SerializedName

data class PostMovie(
    @SerializedName("moviename")
    val moviename: String = "",
    @SerializedName("releasedate")
    val releasedate: String = "",
    @SerializedName("image")
    val image: Int = 0,

)
