package com.example.androidsprintjetpackcompose.navigation

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.androidsprintjetpackcompose.R

enum class BottomNavItem(
    val title: String,
    val icon: ImageVector,
) {
    CATEGORIES("Категории", Icons.Default.Search),
    RECIPES("Рецепты", Icons.Default.Menu),
    FAVOURITES("Избранное", Icons.Default.Favorite)
}