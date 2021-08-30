package com.example.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.data.network.UnsplashService
import com.example.domain.entity.UnsplashPhoto
import com.example.domain.repository.UnsplashRepository
import kotlinx.coroutines.flow.Flow
import java.lang.Exception
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UnsplashRepositoryImpl @Inject constructor(
    private val unsplashService: UnsplashService
) : UnsplashRepository {

    override fun <T> getSearchResult(query: String): Flow<T> {
        return Pager(
            config = PagingConfig(
                pageSize = 20,
                maxSize = 100,
                enablePlaceholders = false
            ),
            pagingSourceFactory = { UnsplashPagingSource(unsplashService, query) }
        ).flow as Flow<T>
    }

    class UnsplashPagingSource(
        private val unsplashService: UnsplashService,
        private val query: String
    ) : PagingSource<Int, UnsplashPhoto>() {
        override fun getRefreshKey(state: PagingState<Int, UnsplashPhoto>): Int? = state.anchorPosition

        override suspend fun load(params: LoadParams<Int>): LoadResult<Int, UnsplashPhoto> {
            val position = params.key?: 1
            val response = unsplashService.searchPhotos(query, position)

            return try {
                LoadResult.Page(
                    data = response.results,
                    prevKey = if (position == 1) null else position - 1,
                    nextKey = if (position == response.totalPages) null else position + 1
                )
            } catch (e: Exception) {
                LoadResult.Error(e)
            }
        }
    }
}