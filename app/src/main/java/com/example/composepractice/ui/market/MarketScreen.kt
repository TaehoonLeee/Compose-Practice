package com.example.composepractice.ui.market

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.composepractice.Screen

@Composable
fun MarketScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .then(Modifier.padding(8.dp))
    ) {
        Text(text = Screen.Market.route)
    }
}
