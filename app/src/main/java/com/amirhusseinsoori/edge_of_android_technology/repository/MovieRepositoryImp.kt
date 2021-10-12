package com.amirhusseinsoori.edge_of_android_technology.repository

import com.amirhusseinsoori.edge_of_android_technology.data.local.AppDataBase
import com.amirhusseinsoori.edge_of_android_technology.model.remote.Movies
import com.amirhusseinsoori.edge_of_android_technology.data.romote.ApiServices
import com.dropbox.android.external.store4.Fetcher
import com.dropbox.android.external.store4.StoreBuilder
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MovieRepositoryImp
@Inject constructor(
    private val apiServices: ApiServices,
    private val appDataBase: AppDataBase
) : MovieRepository {

    override  fun getPopularMovies(page: Int): Flow<Movies> = flow {
        //appDataBase.userDao().getMovieByPage()
        emit(apiServices.getPopularMovies(page = 1))
    }


    val store = StoreBuilder
        .from(Fetcher.ofFlow { articleId -> apiServices.getPopularMoviesWithFlow(page = 1) }) // api returns Flow<Article>
        .build()
}