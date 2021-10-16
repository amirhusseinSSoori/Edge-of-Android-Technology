package com.amirhusseinsoori.edge_of_android_technology.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.amirhusseinsoori.edge_of_android_technology.data.romote.pager.MoviePagingSource
import com.amirhusseinsoori.edge_of_android_technology.data.source.movie.local.MovieLocalDatasource
import com.amirhusseinsoori.edge_of_android_technology.data.source.movie.remote.MovieRemoteDatasource
import com.amirhusseinsoori.edge_of_android_technology.model.remote.Movie
import com.amirhusseinsoori.edge_of_android_technology.util.DispatcherProvider
import com.amirhusseinsoori.edge_of_android_technology.util.Result
import com.dropbox.android.external.store4.*

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class MovieRepositoryImp
@Inject constructor(
    private val movieRemoteDatasource: MovieRemoteDatasource,
    private val movieLocalDatasource: MovieLocalDatasource,
    private val dispatcher: DispatcherProvider
) : MovieRepository {


    private val store = StoreBuilder
        .from(
            fetcher = Fetcher.of { movieRemoteDatasource.getPopularMovies(page = 1) },
            sourceOfTruth = SourceOfTruth.of(
                reader = movieLocalDatasource::getPopularMovies,
                writer = movieLocalDatasource::insertPopularMovies,
            )
        ).build()

    override fun getPopularMovies(page: Int): Flow<Result<List<Movie>>> = flow {
        store.stream(request = StoreRequest.cached(key = "latest_news", refresh = true))
            .flowOn(dispatcher.io()).collect {
                 response: StoreResponse<List<Movie>> ->
                when (response) {
                    is StoreResponse.Loading -> {
                        emit(Result.loading<List<Movie>>(null))
                    }
                    is StoreResponse.Error -> {
                        emit(Result.error<List<Movie>>())
                    }
                    is StoreResponse.Data -> {
                        val data = response.value
                        emit(Result.success(data))
                    }
                    is StoreResponse.NoNewData -> emit(Result.success(emptyList<Movie>()))
                }
            }

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


}


