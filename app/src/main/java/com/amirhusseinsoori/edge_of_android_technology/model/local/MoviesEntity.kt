package com.amirhusseinsoori.edge_of_android_technology.model.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.amirhusseinsoori.edge_of_android_technology.model.remote.Movie

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
) {
    fun mapperToMovie(): Movie = Movie(
        mId = this.mId,
        mBackdropPath = this.mBackdropPath,
        mFirstAirDate = this.mFirstAirDate,
        mGenreIds = this.mGenreIds,
        mName = this.mName,
        mOriginCountry = this.mOriginCountry,
        mOriginalLanguage = this.mOriginalLanguage,
        mOriginal_name = this.mOriginal_name,
        mOverview = this.mOverview,
        mPopularity = this.mPopularity,
        mPosterPath = this.mPosterPath,
        mVoteAverage = this.mVoteAverage,
        mVoteCount = this.mVoteCount
    )

}
