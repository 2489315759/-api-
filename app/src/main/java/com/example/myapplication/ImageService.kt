package com.example.myapplication

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface ImageService {

    @GET("api/ACG")
    fun getImage(@Query("size")size:String="mw1024",@Query("type")type:String="json",):Call<MyUrl>
}