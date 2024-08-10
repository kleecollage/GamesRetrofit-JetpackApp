package com.example.gameretrofit.repository

import com.example.gameretrofit.data.ApiGames
import com.example.gameretrofit.model.GameList
import com.example.gameretrofit.model.GamesModel
import com.example.gameretrofit.model.SingleGameModel
import kotlinx.coroutines.delay
import javax.inject.Inject

class GamesRepository @Inject constructor(private val apiGames: ApiGames) {
    suspend fun getGames(): List<GameList>? {
        val response = apiGames.getGames()
        if (response.isSuccessful){
            return response.body()?.results
        }
        return null
    }

    suspend fun getGamesPagePaging(page: Int, pageSize: Int): GamesModel {
        delay(3000L) // simulacion de retraso
        return apiGames.getGamesPaging(page, pageSize)
    }


    suspend fun getGameById(id: Int): SingleGameModel? {
        val response = apiGames.getGameById(id)
        if (response.isSuccessful) {
            return response.body()
        }
        return null
    }

    suspend fun getGameByName(name: String): SingleGameModel? {
        val response = apiGames.getGameByName(name)
        if (response.isSuccessful) {
            return response.body()
        }
        return null
    }
}