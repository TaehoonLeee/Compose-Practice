package com.example.data.entity

import com.example.domain.entity.UnsplashPhoto
import com.google.gson.annotations.SerializedName

data class UnsplashResponse(
    val results: List<UnsplashPhoto>,
    @SerializedName("total_pages")
    val totalPages: Int
)