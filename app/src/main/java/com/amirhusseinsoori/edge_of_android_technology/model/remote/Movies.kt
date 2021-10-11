package com.amirhusseinsoori.edge_of_android_technology.model.remote

import com.google.gson.annotations.SerializedName

data class Movies(
    @SerializedName("page")
    val mPage: Int,
    @SerializedName("results")
    val mResults: List<Movie>,
    @SerializedName("total_pages")
    val mTotalPages: Int,
    @SerializedName("total_results")
    val mTotalResults: Int,
)