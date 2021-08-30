package com.example.domain.repository

import kotlinx.coroutines.flow.Flow

interface UnsplashRepository {

    fun <T> getSearchResult(query: String): Flow<T>
}