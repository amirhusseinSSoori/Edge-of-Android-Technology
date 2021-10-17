package com.amirhusseinsoori.edge_of_android_technology.data.local

import android.provider.SyncStateContract.Helpers.insert
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.amirhusseinsoori.edge_of_android_technology.model.local.MoviesEntity
import kotlinx.coroutines.flow.Flow


@Dao
interface MovieDao {
    @Query("SELECT * FROM MoviesEntity")
     fun getMovieByPage(): Flow<List<MoviesEntity>>

     @Query("DELETE  FROM MoviesEntity")
    suspend fun deleteAll()

    @Insert
    suspend fun insert(movie: List<MoviesEntity>)


    @Transaction
    suspend fun update(news: List<MoviesEntity>) {
        deleteAll()
        insert(news)
    }
}