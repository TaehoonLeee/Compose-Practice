package com.example.data.network

import com.example.data.entity.UnsplashResponse
import io.ktor.client.*
import io.ktor.client.request.*
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UnsplashService @Inject constructor(
    private val httpClient: HttpClient
) {

    suspend fun searchPhotos(query: String, page: Int, perPage: Int = 20): UnsplashResponse {
        return httpClient.get(path = "search/photos") {
            parameter("query", query)
            parameter("page", page)
            parameter("perPage", perPage)
        }
    }
}