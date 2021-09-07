package com.example.composepractice.ui.bottomnav

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.*
import coil.annotation.ExperimentalCoilApi
import com.example.composepractice.ui.gallery.GalleryScreen
import com.example.composepractice.ui.gallery.TestScreen
import com.example.composepractice.ui.market.MarketScreen
import com.example.composepractice.ui.mypage.MyPageScreen
import com.example.composepractice.ui.theme.ComposePracticeTheme
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@Composable
@ExperimentalCoilApi
fun BottomNavApp(navigationManager: NavigationManager) {
    val navController = rememberNavController()
    val coroutineScope = rememberCoroutineScope()
    val items = listOf(
        Icons.Default.ShoppingCart to Direction.Market.route,
        Icons.Default.Favorite to Direction.Landing.route,
        Icons.Default.Person to Direction.MyPage.route
    )

    LaunchedEffect(Unit) {
        coroutineScope.launch {
            navigationManager.direction.collect { direction ->
                direction?: return@collect
                navController.navigate(direction.route.plus("/${direction.args}"), direction.option)
            }
        }
    }

    ComposePracticeTheme {
        Surface(color = MaterialTheme.colors.background) {
            Scaffold(
                bottomBar = {
                    BottomNavigation(
                        backgroundColor = Color.Black
                    ) {
                        val navBackStackEntry by navController.currentBackStackEntryAsState()
                        val currentRoute = navBackStackEntry?.destination?.route

                        items.forEach { (icon, route) ->
                            BottomNavigationItem(
                                selectedContentColor = Color.White,
                                unselectedContentColor = Color.Gray,
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
                    startDestination = Direction.Landing.route,
                ) {
                    addComposableDestinations()
                }
            }
        }
    }
}

@ExperimentalCoilApi
fun NavGraphBuilder.addComposableDestinations() {
    composable(Direction.Landing.route) {
        GalleryScreen()
    }
    composable(Direction.MyPage.route) {
        MyPageScreen()
    }
    composable(Direction.Market.route) {
        MarketScreen()
    }
    composable(Direction.Test.route.plus("/{testArgs}")) {
        TestScreen(it.arguments?.getString("testArgs"))
    }
}

private fun navigate(navController: NavController, route: String) {
    navController.navigate(route) {
        launchSingleTop = true
        restoreState = true
        popUpTo(navController.graph.findStartDestination().id) {
            saveState = true
        }
    }
}