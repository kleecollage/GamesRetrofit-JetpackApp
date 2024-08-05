package com.example.gameretrofit.model

import java.sql.Array

data class GamesModel(
    val count: Int,
    val results: List<GameList>
)

data class GameList(
    val id: Int,
    val name: String,
    val background_image: String
)