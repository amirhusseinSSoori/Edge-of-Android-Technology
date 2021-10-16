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

    override fun getAllPopularMovies(): Flow<PagingData<Movie>> =
        Pager(
            config = PagingConfig(
                pageSize = 20,
                maxSize = 100,
                enablePlaceholders = false
            ),
            pagingSourceFactory = { MoviePagingSource(apiServices) }
        ).flow
     var store = StoreBuilder.from(
        fetcher = Fetcher.of { _: String ->
            apiServices.getPopularMovies(page = 1)
        },
        sourceOfTruth = SourceOfTruth.Companion.of(
            reader = { key -> appDataBase.userDao().getMovieByPage() },
            writer = { key: String, input: Movies ->
                val latestNews = input.mResults
                appDataBase.userDao().update(latestNews.map { it.mapperToEntity() })
            }
        )
    ).build()

    fun getLatestNews(): Flow<ErrorHandeling<List<MoviesEntity>>> {
        return flow {
            store.stream(StoreRequest.cached(key = "latest_news", refresh = true))
                .flowOn(dispatcher.io())
                .collect { response: StoreResponse<List<MoviesEntity>> ->
                    when (response) {
                        is StoreResponse.Loading -> {

                            print("[Store 4] Loading from ${response.origin} \n")
                            emit(ErrorHandeling.loading<List<MoviesEntity>>())
                        }
                        is StoreResponse.Error -> {
                            print("[Store 4] Error from  ${response.origin}  \n")
                            emit(ErrorHandeling.error<List<MoviesEntity>>())
                        }
                        is StoreResponse.Data -> {
                            val data = response.value
                            Log.e("TAG", "getLatestNews: ${ "[Store 4] Data from ${response.origin}  with ${response.value.size} elements \n"}", )
                            print("[Store 4] Data from ${response.origin}  with ${response.value.size} elements \n")
                            emit(ErrorHandeling.success(data))
                        }
                        is StoreResponse.NoNewData -> emit(ErrorHandeling.success(emptyList<MoviesEntity>()))
                    }
                }
        }.flowOn(dispatcher.io())
    }




}

