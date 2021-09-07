package com.example.composepractice.ui.gallery

import android.os.Parcelable
import androidx.compose.foundation.layout.Box
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.annotation.ExperimentalCoilApi
import com.example.composepractice.ui.theme.ComposePracticeTheme
import kotlinx.parcelize.Parcelize

@Composable
@ExperimentalCoilApi
fun GalleryScreen(viewModel: GalleryViewModel = hiltViewModel()) {
    ComposePracticeTheme {
        Box {
            UnsplashPhotoList(viewModel.searchResult) {
                viewModel.navigateToTestScreen("testArgs")
            }
        }
    }
}

@Composable
fun TestScreen(testArgs: String?) {
    Box {
        Text(text = testArgs?: "null")
    }
}

@Parcelize
data class TestModel(val test: Int) : Parcelable