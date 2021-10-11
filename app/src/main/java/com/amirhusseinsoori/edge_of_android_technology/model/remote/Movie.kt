package com.amirhusseinsoori.edge_of_android_technology.model.remote

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
)
