package com.example.composepractice.ui.bottomnav

import android.os.Bundle
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.Saver
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composepractice.Screen
import com.example.composepractice.ui.gallery.GalleryScreen
import com.example.composepractice.ui.market.MarketScreen
import com.example.composepractice.ui.mypage.MyPageScreen
import com.example.composepractice.ui.theme.ComposePracticeTheme

@Composable
fun BottomNavApp() {
    val navController = rememberNavController()
    val marketNavState = rememberSaveable(saver = NavStateSaver()) {
        mutableStateOf(Bundle())
    }
    var currentTab by rememberSaveable(saver = ScreenSaver()) {
        mutableStateOf(Screen.Landing)
    }

    ComposePracticeTheme {
        Surface(color = MaterialTheme.colors.background) {
            Scaffold(
                bottomBar = {
                    BottomNavigation {
                        BottomNavigationItem(
                            icon = { Icon(imageVector = Icons.Default.ShoppingCart, contentDescription = null) },
                            label = { Text(text = Screen.Market.route) },
                            selected = currentTab == Screen.Market,
                            onClick = {
                                currentTab = Screen.Market
                                navController.navigate(currentTab.route)
                            }
                        )
                        BottomNavigationItem(
                            icon = { Icon(imageVector = Icons.Default.Favorite, contentDescription = null) },
                            label = { Text(text = Screen.Landing.route )},
                            selected = currentTab == Screen.Landing,
                            onClick = {
                                currentTab = Screen.Landing
                                navController.navigate(currentTab.route)
                            }
                        )
                        BottomNavigationItem(
                            icon = { Icon(imageVector = Icons.Default.Person, contentDescription = null) },
                            label = { Text(text = Screen.MyPage.route) },
                            selected = currentTab == Screen.MyPage,
                            onClick = {
                                currentTab = Screen.MyPage
                                navController.navigate(currentTab.route)
                            }
                        )
                    }
                }
            ) {
                NavHost(
                    navController = navController,
                    startDestination = Screen.Landing.route,
                    builder = {
                        addComposableDestinations(marketNavState)
                    }
                )
            }
        }
    }
}

fun NavGraphBuilder.addComposableDestinations(marketState: MutableState<Bundle>) {
    composable(Screen.Landing.route) {
        GalleryScreen()
    }
    composable(Screen.MyPage.route) {
        MyPageScreen()
    }
    composable(Screen.Market.route) {
        MarketScreen(navState = marketState)
    }
}

fun NavStateSaver(): Saver<MutableState<Bundle>, out Any> = Saver(
    save = { it.value },
    restore = { mutableStateOf(it) }
)

fun ScreenSaver(): Saver<MutableState<Screen>, *> = Saver(
    save = { it.value.saveState() },
    restore = { mutableStateOf(Screen.restoreState(it)) }
)