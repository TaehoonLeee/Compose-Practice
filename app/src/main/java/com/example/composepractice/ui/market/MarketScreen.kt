package com.example.composepractice.ui.market

import android.os.Bundle
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.composepractice.Screen

@Composable
fun MarketScreen(navState: MutableState<Bundle>) {
    val navController = rememberNavController()

    DisposableEffect(Unit) {
        val callback = NavController.OnDestinationChangedListener { controller, _, _ ->
            navState.value = controller.saveState()?: Bundle()
        }
        navController.addOnDestinationChangedListener(callback)
        navController.restoreState(navState.value)

        onDispose {
            navController.removeOnDestinationChangedListener(callback)
            navController.enableOnBackPressed(false)
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .then(Modifier.padding(8.dp))
    ) {
        Text(text = Screen.Market.route)
    }
}
