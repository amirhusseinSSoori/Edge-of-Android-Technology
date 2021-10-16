package com.amirhusseinsoori.edge_of_android_technology.ui.movies

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.amirhusseinsoori.edge_of_android_technology.data.romote.ErrorHandeling
import com.amirhusseinsoori.edge_of_android_technology.model.local.MoviesEntity
import com.amirhusseinsoori.edge_of_android_technology.model.remote.Movie
import com.amirhusseinsoori.edge_of_android_technology.repository.MovieRepositoryImp
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(
    private val mMovieRepository: MovieRepositoryImp
) : ViewModel() {

    private val _state = MutableStateFlow<MovieState>(MovieState.Loading)
    var state: StateFlow<MovieState> = _state



    private val _pagingState = MutableStateFlow<Flow<PagingData<Movie>>>(emptyFlow())
    val pagingState: StateFlow<Flow<PagingData<Movie>>> = _pagingState

    init {
        getMovie()
    }

    private fun getMovie() {
        viewModelScope.launch {
            mMovieRepository.getLatestNews().collect {
                _state.value = MovieState.Successful(it)
            }
        }

    }

    //with paging
    private fun getAllMovie() {
        _pagingState.value= mMovieRepository.getAllPopularMovies().cachedIn(viewModelScope)
    }


}

sealed class MovieState {

    object Loading : MovieState()
    data class Successful(val movies: ErrorHandeling<List<MoviesEntity>>) : MovieState()
    data class Throwable(val throwable: kotlin.Throwable) : MovieState()
}

