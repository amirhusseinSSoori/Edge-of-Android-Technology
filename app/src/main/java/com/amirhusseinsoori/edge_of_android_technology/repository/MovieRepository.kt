package com.amirhusseinsoori.edge_of_android_technology.repository

import androidx.paging.PagingData
import com.amirhusseinsoori.edge_of_android_technology.model.remote.Movie
import com.amirhusseinsoori.edge_of_android_technology.model.remote.Movies
import com.amirhusseinsoori.edge_of_android_technology.util.Result
import kotlinx.coroutines.flow.Flow


interface MovieRepository {
     fun getPopularMovies(page: Int): Flow<Result<List<Movie>>>
     fun getAllPopularMovies(): Flow<PagingData<Movie>>
}