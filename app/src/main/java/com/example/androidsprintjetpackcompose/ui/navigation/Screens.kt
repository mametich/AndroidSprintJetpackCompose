package com.example.androidsprintjetpackcompose.ui.navigation

sealed class Screen(val route: String) {
    object Categories : Screen("categories")
    object Recipes : Screen("recipes/{categoryId}") {
        fun createRoute(categoryId: Int) = "recipes/$categoryId"
    }
    object Favourites : Screen("favourites")
}