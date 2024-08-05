package com.example.gameretrofit.repository

import com.example.gameretrofit.data.ApiGames
import com.example.gameretrofit.model.GameList
import javax.inject.Inject

class GamesRepository @Inject constructor(private val apiGames: ApiGames) {
    suspend fun getGames(): List<GameList>? {
        val response = apiGames.getGames()
        if (response.isSuccessful){
            return response.body()?.results
        }
        return null
    }
}