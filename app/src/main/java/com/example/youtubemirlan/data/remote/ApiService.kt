package com.example.youtubemirlan.data.remote

import com.example.youtubemirlan.data.model.PlayLists
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("playlists")
    fun getPlayLists(
        @Query("key") key: String,
        @Query("part") part: String,
        @Query("channelId") channelId: String
    ): Call<PlayLists>
}