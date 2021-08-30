package com.example.composepractice.ui.gallery

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.composepractice.ui.compose.UnsplashPhotoList
import com.example.composepractice.ui.theme.ComposePracticeTheme

@Composable
fun GalleryScreen(viewModel: GalleryViewModel = hiltViewModel()) {
    ComposePracticeTheme {
        Box {
            UnsplashPhotoList(viewModel.searchResult)
        }
    }
}