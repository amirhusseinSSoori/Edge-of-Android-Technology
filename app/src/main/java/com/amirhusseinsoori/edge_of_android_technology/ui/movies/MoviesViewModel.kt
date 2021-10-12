package com.amirhusseinsoori.edge_of_android_technology.ui.movies

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.amirhusseinsoori.edge_of_android_technology.model.remote.Movie
import com.amirhusseinsoori.edge_of_android_technology.repository.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(
    private val mMovieRepository: MovieRepository
) : ViewModel() {

    private val _state = MutableStateFlow<MovieState>(MovieState.None)
    val state: StateFlow<MovieState> = _state



    private val _pagingState = MutableStateFlow<Flow<PagingData<Movie>>>(emptyFlow())
    val pagingState: StateFlow<Flow<PagingData<Movie>>> = _pagingState

    init {
        getMovie()
    }

    private fun getMovie() {
        viewModelScope.launch {
            _state.value = MovieState.Loading
            mMovieRepository.getPopularMovies(page = 1).catch {
                _state.value = MovieState.Throwable(it)
            }.collect {
                _state.value = MovieState.Successful(it.mResults)
            }
        }

    }

    //with paging
    private fun getAllMovie() {
        _pagingState.value= mMovieRepository.getAllPopularMovies().cachedIn(viewModelScope)
    }


}

sealed class MovieState {
    object None : MovieState()
    object Loading : MovieState()
    data class Successful(val movies: List<Movie>) : MovieState()
    data class Throwable(val throwable: kotlin.Throwable) : MovieState()
}

