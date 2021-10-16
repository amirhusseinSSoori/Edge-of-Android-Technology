package com.amirhusseinsoori.edge_of_android_technology.data.source.movie.remote

import com.amirhusseinsoori.edge_of_android_technology.model.remote.Movie
import com.amirhusseinsoori.edge_of_android_technology.model.remote.Movies
import kotlinx.coroutines.flow.Flow

interface MovieRemoteDatasource {
    fun getPopularMovies(page: Int): Flow<List<Movie>>
}