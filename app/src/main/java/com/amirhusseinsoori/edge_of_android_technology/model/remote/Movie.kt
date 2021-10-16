package com.amirhusseinsoori.edge_of_android_technology.model.remote

import com.amirhusseinsoori.edge_of_android_technology.model.local.MoviesEntity
import com.google.gson.annotations.SerializedName

data class Movie(
    @SerializedName("backdrop_path")
    val mBackdropPath: String,
    @SerializedName("first_air_date")
    val mFirstAirDate: String,
    @SerializedName("genre_ids")
    val mGenreIds: List<Int>,
    @SerializedName("id")
    val mId: Int,
    @SerializedName("name")
    val mName: String,
    @SerializedName("origin_country")
    val mOriginCountry: List<String>,
    @SerializedName("original_language")
    val mOriginalLanguage: String,
    @SerializedName("original_name")
    val mOriginal_name: String,
    @SerializedName("overview")
    val mOverview: String,
    @SerializedName("popularity")
    val mPopularity: Double,
    @SerializedName("poster_path")
    val mPosterPath: String,
    @SerializedName("vote_average")
    val mVoteAverage: Double,
    @SerializedName("vote_count")
    val mVoteCount: Double,
) {
    fun mapperToEntity(): MoviesEntity = MoviesEntity(
        this.mId,
        this.mBackdropPath,
        this.mFirstAirDate,
        this.mGenreIds,
        this.mName,
        this.mOriginCountry,
        this.mOriginalLanguage,
        this.mOriginal_name,
        this.mOverview,
        this.mPopularity,
        this.mPosterPath,
        this.mVoteAverage,
        this.mVoteCount
    )

}
