package com.amirhusseinsoori.edge_of_android_technology.data.source.movie.local

import com.amirhusseinsoori.edge_of_android_technology.model.remote.Movie
import com.amirhusseinsoori.edge_of_android_technology.model.remote.Movies
import kotlinx.coroutines.flow.Flow

interface MovieLocalDatasource {
    fun getPopularMovies(page: Int): Flow<List<Movie>>
    suspend fun insertPopularMovies(key: String, movies: Flow<List<Movie>>)
}