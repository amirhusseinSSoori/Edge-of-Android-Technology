package com.amirhusseinsoori.edge_of_android_technology.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.amirhusseinsoori.edge_of_android_technology.model.local.MoviesEntity
import kotlinx.coroutines.flow.Flow


@Dao
abstract class MovieDao {
    @Query("SELECT * FROM MoviesEntity")
    abstract fun getMovieByPage(): Flow<List<MoviesEntity>>

    @Insert
    abstract fun insertMove(movie: MoviesEntity)
}