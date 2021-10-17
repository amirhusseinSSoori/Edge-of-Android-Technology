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
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MoviesViewModel @Inject constructor(
    private val mMovieRepository: MovieRepositoryImp
) : ViewModel() {

    private val _state = MutableStateFlow<List<MoviesEntity>>(emptyList())
    var state: StateFlow<List<MoviesEntity>> = _state




    init {
        getMovie()
    }


    private fun getMovie() {
        viewModelScope.launch {
            mMovieRepository.getLatestNews().collect {
                _state.value = it
            }



        }

    }



}


