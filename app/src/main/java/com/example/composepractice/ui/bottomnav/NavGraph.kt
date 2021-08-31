package com.example.composepractice.ui.bottomnav

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.*
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.composepractice.Screen
import com.example.composepractice.ui.gallery.GalleryScreen
import com.example.composepractice.ui.market.MarketScreen
import com.example.composepractice.ui.mypage.MyPageScreen
import com.example.composepractice.ui.theme.ComposePracticeTheme

@Composable
fun BottomNavApp() {
    val navController = rememberNavController()
    val items = listOf(
        Icons.Default.ShoppingCart to Screen.Market.route,
        Icons.Default.Favorite to Screen.Landing.route,
        Icons.Default.Person to Screen.MyPage.route
    )

    ComposePracticeTheme {
        Surface(color = MaterialTheme.colors.background) {
            Scaffold(
                bottomBar = {
                    BottomNavigation {
                        val navBackStackEntry by navController.currentBackStackEntryAsState()
                        val currentRoute = navBackStackEntry?.destination?.route

                        items.forEach { (icon, route) ->
                            BottomNavigationItem(
                                icon = { Icon(imageVector = icon, contentDescription = null) },
                                selected = currentRoute == route,
                                onClick = { navigate(navController, route) }
                            )
                        }
                    }
                }
            ) {
                NavHost(
                    navController = navController,
                    startDestination = Screen.Landing.route,
                    builder = {
                        addComposableDestinations()
                    }
                )
            }
        }
    }
}

fun NavGraphBuilder.addComposableDestinations() {
    composable(Screen.Landing.route) {
        GalleryScreen()
    }
    composable(Screen.MyPage.route) {
        MyPageScreen()
    }
    composable(Screen.Market.route) {
        MarketScreen()
    }
}

fun navigate(navController: NavController, route: String) {
    navController.navigate(route) {
        launchSingleTop = true
        restoreState = true
        popUpTo(navController.graph.findStartDestination().id) {
            saveState = true
        }
    }
}