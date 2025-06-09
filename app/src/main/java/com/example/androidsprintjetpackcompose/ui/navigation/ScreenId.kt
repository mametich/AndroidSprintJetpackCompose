package com.example.androidsprintjetpackcompose.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector

enum class ScreenId(
    val title: String,
    val icon: ImageVector,
) {
    CATEGORIES("Категории", Icons.Default.Search),
    FAVOURITES("Избранное", Icons.Default.Favorite),
    RECIPES("Рецепты", Icons.AutoMirrored.Filled.List)
}