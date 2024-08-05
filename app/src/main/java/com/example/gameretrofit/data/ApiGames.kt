package com.example.gameretrofit.data

import com.example.gameretrofit.model.GamesModel
import com.example.gameretrofit.utils.Constants.Companion.API_KEY
import com.example.gameretrofit.utils.Constants.Companion.END_POINT
import retrofit2.Response
import retrofit2.http.GET

interface ApiGames {
    @GET(END_POINT + API_KEY)
    suspend fun getGames(): Response<GamesModel>
}