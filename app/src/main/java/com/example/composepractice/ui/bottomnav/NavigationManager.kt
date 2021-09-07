package com.example.composepractice.ui.bottomnav

import androidx.navigation.NavOptions
import androidx.navigation.navOptions
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.receiveAsFlow

class NavigationManager {
    private val _direction: Channel<Direction?> = Channel()
    val direction: Flow<Direction?> get() = _direction.receiveAsFlow()


    fun setDirection(direction: Direction) {
        _direction.trySend(direction)
    }
}

sealed class Direction(
    val route: String,
    var args: String? = null,
    val option: NavOptions? = null
) {
    object Landing : Direction("Landing")
    object Market : Direction("Market")
    object MyPage : Direction("MyPage")
    object Test : Direction("Test", option = navOptions { })
}