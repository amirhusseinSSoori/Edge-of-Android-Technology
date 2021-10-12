package com.amirhusseinsoori.edge_of_android_technology.repository

import com.amirhusseinsoori.edge_of_android_technology.data.local.AppDataBase
import com.amirhusseinsoori.edge_of_android_technology.model.remote.Movies
import com.amirhusseinsoori.edge_of_android_technology.data.romote.ApiServices
import com.amirhusseinsoori.edge_of_android_technology.model.remote.Movie
import com.amirhusseinsoori.edge_of_android_technology.util.DispatcherProvider
import com.dropbox.android.external.store4.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class MovieRepositoryImp
@Inject constructor(
    private val apiServices: ApiServices,
    private val appDataBase: AppDataBase,
    private val dispatcher: DispatcherProvider
) : MovieRepository {

    override  fun getPopularMovies(page: Int): Flow<Movies> = flow {
        emit(apiServices.getPopularMovies(page = 1))
    }

}