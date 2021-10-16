package com.amirhusseinsoori.edge_of_android_technology.repository

import androidx.paging.PagingData
import com.amirhusseinsoori.edge_of_android_technology.model.remote.Movie
import com.amirhusseinsoori.edge_of_android_technology.model.remote.Movies
import kotlinx.coroutines.flow.Flow


interface MovieRepository {
     fun getPopularMovies(page: Int): Flow<Movies>
     fun getAllPopularMovies(): Flow<PagingData<Movie>>

}