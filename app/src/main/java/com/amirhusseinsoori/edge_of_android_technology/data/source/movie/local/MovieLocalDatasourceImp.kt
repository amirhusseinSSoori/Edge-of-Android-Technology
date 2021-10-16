package com.amirhusseinsoori.edge_of_android_technology.data.source.movie.local

import com.amirhusseinsoori.edge_of_android_technology.data.local.AppDataBase
import com.amirhusseinsoori.edge_of_android_technology.model.remote.Movie
import com.amirhusseinsoori.edge_of_android_technology.model.remote.Movies
import com.amirhusseinsoori.edge_of_android_technology.util.DispatcherProvider
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class MovieLocalDatasourceImp
@Inject constructor(
    private val appDataBase: AppDataBase,
    private val dispatcher: DispatcherProvider
) : MovieLocalDatasource {

    override fun getPopularMovies(page: Int): Flow<List<Movie>> =
        appDataBase.userDao().getMovieByPage().flowOn(dispatcher.io()).map { movieEntities ->
            movieEntities.map { it.mapperToMovie() }
        }


    override suspend fun insertPopularMovies(movies: List<Movie>) {
        appDataBase.userDao().insertMove(movies.map { it.mapperToEntity() })
    }

}