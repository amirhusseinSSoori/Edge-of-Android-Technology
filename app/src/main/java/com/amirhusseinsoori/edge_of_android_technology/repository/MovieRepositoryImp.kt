package com.amirhusseinsoori.edge_of_android_technology.repository

import com.amirhusseinsoori.edge_of_android_technology.data.local.AppDataBase
import com.amirhusseinsoori.edge_of_android_technology.model.remote.Movies
import com.amirhusseinsoori.edge_of_android_technology.data.romote.ApiServices
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
}