package com.example.androidsprintjetpackcompose

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.androidsprintjetpackcompose.ui.categories.CategoriesScreen
import com.example.androidsprintjetpackcompose.ui.favorites.FavoritesScreen
import com.example.androidsprintjetpackcompose.ui.navigation.BottomNavigation
import com.example.androidsprintjetpackcompose.ui.navigation.ScreenId
import com.example.androidsprintjetpackcompose.ui.recipes.RecipesScreen
import com.example.androidsprintjetpackcompose.ui.theme.AndroidSprintJetpackComposeTheme

@Composable
fun RecipesApp(modifier: Modifier = Modifier) {

    var currentNavItem by remember { mutableStateOf(ScreenId.CATEGORIES) }
    var selectedCategoryId by remember { mutableStateOf<Int?>(null) }

    AndroidSprintJetpackComposeTheme {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            bottomBar = {
                BottomNavigation(
                    onFavouritesClick = { currentNavItem = ScreenId.FAVOURITES },
                    onCategoriesClick = { currentNavItem = ScreenId.CATEGORIES }
                )
            }
        ) { innerPadding ->
            when (currentNavItem) {
                ScreenId.CATEGORIES -> CategoriesScreen(
                    paddingValues = innerPadding,
                    onCategoryClick = { categoryId ->
                        selectedCategoryId = categoryId
                        currentNavItem = ScreenId.RECIPES
                    }
                )

                ScreenId.FAVOURITES -> FavoritesScreen(innerPadding)

                ScreenId.RECIPES -> RecipesScreen(
                    paddingValues = innerPadding,
                    categoryId = selectedCategoryId ?: error("Category ID is required"),
                    onRecipeClick = { recipeId ->

                    }
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun RecipesAppPreview() {
    RecipesApp()
}