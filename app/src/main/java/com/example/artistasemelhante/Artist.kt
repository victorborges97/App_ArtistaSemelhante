package com.example.artistasemelhante

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface Artist {
    @GET("q")
    fun getPosts(@Query("id") id: String?): Call<List<PostArtist?>?>?
}