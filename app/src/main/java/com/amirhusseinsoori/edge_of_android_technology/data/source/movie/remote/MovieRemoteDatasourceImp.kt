package com.amirhusseinsoori.edge_of_android_technology.data.source.movie.remote

import com.amirhusseinsoori.edge_of_android_technology.data.romote.ApiServices
import com.amirhusseinsoori.edge_of_android_technology.model.remote.Movie
import com.amirhusseinsoori.edge_of_android_technology.model.remote.Movies
import com.amirhusseinsoori.edge_of_android_technology.util.DispatcherProvider
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class MovieRemoteDatasourceImp
@Inject constructor(
    private val apiServices: ApiServices,
    private val dispatcher: DispatcherProvider
) : MovieRemoteDatasource {

    override fun getPopularMovies(page: Int): Flow<List<Movie>> = flow {
        emit(apiServices.getPopularMovies(page = 1).mResults)
    }.flowOn(dispatcher.io())

}