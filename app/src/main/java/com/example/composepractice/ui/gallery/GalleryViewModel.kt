package com.example.composepractice.ui.gallery

import androidx.lifecycle.ViewModel
import androidx.paging.PagingData
import com.example.domain.entity.UnsplashPhoto
import com.example.domain.interactor.GetSearchResultUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class GalleryViewModel @Inject constructor(
    getSearchResultUseCase: GetSearchResultUseCase
) : ViewModel() {

    val searchResult = getSearchResultUseCase.execute<PagingData<UnsplashPhoto>>(DEFAULT_QUERY)

    companion object {
        const val DEFAULT_QUERY = "cats"
    }
}