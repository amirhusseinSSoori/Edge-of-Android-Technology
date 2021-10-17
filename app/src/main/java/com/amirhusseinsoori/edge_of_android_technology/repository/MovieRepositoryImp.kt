package com.amirhusseinsoori.edge_of_android_technology.repository

import android.util.Log
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.amirhusseinsoori.edge_of_android_technology.data.local.AppDataBase
import com.amirhusseinsoori.edge_of_android_technology.model.remote.Movies
import com.amirhusseinsoori.edge_of_android_technology.data.romote.ApiServices
import com.amirhusseinsoori.edge_of_android_technology.data.romote.ErrorHandeling
import com.amirhusseinsoori.edge_of_android_technology.data.romote.pager.MoviePagingSource
import com.amirhusseinsoori.edge_of_android_technology.model.local.MoviesEntity
import com.amirhusseinsoori.edge_of_android_technology.model.remote.Movie
import com.amirhusseinsoori.edge_of_android_technology.util.DispatcherProvider
import com.dropbox.android.external.store4.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.*
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


    var store = StoreBuilder.from(
        fetcher = Fetcher.of { _: String ->
            apiServices.getPopularMovies(page = 40)
        },
        sourceOfTruth = SourceOfTruth.Companion.of(
            reader = { _ -> appDataBase.userDao().getMovieByPage() },
            writer = { _: String, input: Movies ->
                val latestNews = input.mResults
                appDataBase.userDao().update(latestNews.map { it.mapperToEntity() })
            }
        )
    ).build()


    fun getLatestNews(): Flow<List<MoviesEntity>> {
        return flow {
            store.stream(StoreRequest.cached(key = "latest_news", refresh = true))
                .flowOn(dispatcher.io())
                .collect { response: StoreResponse<List<MoviesEntity>> ->
                    when (response) {
                        is StoreResponse.Loading -> {
                            emit(emptyList<MoviesEntity>())
                        }
                        is StoreResponse.Error -> { emit(emptyList<MoviesEntity>()) }
                        is StoreResponse.Data -> {
                            emit(response.value)
                        }
                        is StoreResponse.NoNewData -> emit(emptyList<MoviesEntity>())
                    }
                }
        }
    }




}

