package com.example.composepractice

import android.os.Bundle
import androidx.core.os.bundleOf

sealed class Screen(val route: String) {
    object Market : Screen("Market")
    object Landing : Screen("Landing")
    object MyPage : Screen("MyPage")

    fun saveState() = bundleOf("route" to route)

    companion object {
        fun restoreState(bundle: Bundle): Screen {
            return Landing
        }
    }
}