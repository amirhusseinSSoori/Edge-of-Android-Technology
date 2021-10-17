package com.amirhusseinsoori.edge_of_android_technology.data.romote

import com.amirhusseinsoori.edge_of_android_technology.BuildConfig
import com.amirhusseinsoori.edge_of_android_technology.model.remote.Movies
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiServices {

    @GET("tv/popular")
     fun getPopularMovies(
        @Query("api_key") apiKey: String = BuildConfig.API_KEY,
        @Query("page") page: Int
    ): Movies



}