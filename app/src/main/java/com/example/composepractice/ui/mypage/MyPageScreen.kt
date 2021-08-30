package com.example.composepractice.ui.mypage

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.composepractice.Screen

@Composable
fun MyPageScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .then(Modifier.padding(8.dp))
    ) {
        Text(text = Screen.MyPage.route)
    }
}