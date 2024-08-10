package com.example.gameretrofit.data

import com.example.gameretrofit.model.GamesModel
import com.example.gameretrofit.model.SingleGameModel
import com.example.gameretrofit.utils.Constants.Companion.API_KEY
import com.example.gameretrofit.utils.Constants.Companion.END_POINT
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiGames {
    @GET(END_POINT + API_KEY)
    suspend fun getGames(): Response<GamesModel>

    @GET(END_POINT + API_KEY)
    suspend fun getGamesPaging(@Query("page") page: Int, @Query("page_size") pageSize: Int): GamesModel // page puede tener cualquier otro nombre

    @GET("$END_POINT/{id}$API_KEY")
    suspend fun getGameById(@Path(value = "id")id: Int): Response<SingleGameModel>

    @GET("$END_POINT/{name}$API_KEY")
    suspend fun getGameByName(@Path(value = "name")name: String): Response<SingleGameModel>
}