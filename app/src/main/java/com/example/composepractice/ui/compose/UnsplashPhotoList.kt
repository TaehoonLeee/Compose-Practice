package com.example.composepractice.ui.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.paging.PagingData
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import coil.annotation.ExperimentalCoilApi
import coil.compose.ImagePainter
import coil.compose.rememberImagePainter
import com.example.domain.entity.UnsplashPhoto
import kotlinx.coroutines.flow.Flow

@Composable
@ExperimentalCoilApi
fun UnsplashPhotoList(photos: Flow<PagingData<UnsplashPhoto>>) {
    val lazyPagingItems = photos.collectAsLazyPagingItems()
    LazyColumn {
        items(lazyPagingItems) {
            UnsplashPhotoItem(photo = it)
        }
    }
}

@Composable
@ExperimentalCoilApi
fun UnsplashPhotoItem(
    photo: UnsplashPhoto?
) {
    val painter = rememberImagePainter(data = photo?.urls?.regular)
    Box(
        Modifier
            .fillMaxWidth()
            .height(250.dp)
    ) {
        Image(
            painter = painter,
            contentDescription = null,
            contentScale = ContentScale.None
        )

        if (painter.state is ImagePainter.State.Loading) CircularProgressIndicator(Modifier.align(Alignment.Center))
    }
}