package com.amirhusseinsoori.edge_of_android_technology.model.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class MoviesEntity(
    @PrimaryKey val mId: Int,
    @ColumnInfo val mBackdropPath: String,
    @ColumnInfo val mFirstAirDate: String,
    @ColumnInfo val mGenreIds: List<Int>,
    @ColumnInfo val mName: String,
    @ColumnInfo val mOriginCountry: List<String>,
    @ColumnInfo val mOriginalLanguage: String,
    @ColumnInfo val mOriginal_name: String,
    @ColumnInfo val mOverview: String,
    @ColumnInfo val mPopularity: Double,
    @ColumnInfo val mPosterPath: String,
    @ColumnInfo val mVoteAverage: Double,
    @ColumnInfo val mVoteCount: Double,
)
