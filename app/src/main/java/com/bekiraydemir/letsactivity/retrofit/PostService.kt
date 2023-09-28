package com.bekiraydemir.letsactivity.retrofit

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PostService {
    @GET("movie/popular?api_key=${Constant.API_KEY}")
    fun listPost(): Call<ApiResponse>
}