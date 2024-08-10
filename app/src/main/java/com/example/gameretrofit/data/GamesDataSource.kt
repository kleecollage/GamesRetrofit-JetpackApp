package com.example.gameretrofit.data

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.gameretrofit.model.GameList
import com.example.gameretrofit.repository.GamesRepository

class GamesDataSource(private val repo: GamesRepository): PagingSource<Int, GameList>() {
    override fun getRefreshKey(state: PagingState<Int, GameList>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, GameList> {
        return try {
            val nextPageNumber = params.key ?: 1 // comenzamos en pag 1
            val response = repo.getGamesPagePaging(nextPageNumber, 5)
            LoadResult.Page(
                data = response.results, // aqui viene la carga
                prevKey = null,
                nextKey = if (response.results.isNotEmpty()) nextPageNumber + 1 else null // siguiente pag
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

}