package com.amirhusseinsoori.edge_of_android_technology.data.romote.pager

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.amirhusseinsoori.edge_of_android_technology.data.romote.ApiServices
import com.amirhusseinsoori.edge_of_android_technology.model.remote.Movie
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class MoviePagingSource @Inject constructor(var api: ApiServices) : PagingSource<Int, Movie>() {
    override fun getRefreshKey(state: PagingState<Int, Movie>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Movie> {
        return try {
            val nextPage = params.key ?: 1
            val userList = api.getPopularMovies(page = nextPage)
            LoadResult.Page(
                data = userList.mResults,
                prevKey = if (nextPage == 1) null else nextPage - 1,
                nextKey = if (userList.mResults.isEmpty()) null else nextPage + 1
            )
        } catch (exception: IOException) {
            return LoadResult.Error(exception)
        } catch (exception: HttpException) {
            return LoadResult.Error(exception)
        }
    }
}