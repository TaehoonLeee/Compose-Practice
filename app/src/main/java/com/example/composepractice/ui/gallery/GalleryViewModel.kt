package com.example.composepractice.ui.gallery

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.composepractice.ui.bottomnav.Direction
import com.example.composepractice.ui.bottomnav.NavigationManager
import com.example.domain.entity.UnsplashPhoto
import com.example.domain.interactor.GetSearchResultUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class GalleryViewModel @Inject constructor(
    getSearchResultUseCase: GetSearchResultUseCase,
    private val navigationManager: NavigationManager
) : ViewModel() {

    val searchResult = getSearchResultUseCase
        .execute<PagingData<UnsplashPhoto>>(DEFAULT_QUERY)
        .cachedIn(viewModelScope)

    fun navigateToTestScreen(testArgs: String) {
        navigationManager.setDirection(Direction.Test.apply {
            args = testArgs
        })
    }

    companion object {
        const val DEFAULT_QUERY = "cats"
    }
}