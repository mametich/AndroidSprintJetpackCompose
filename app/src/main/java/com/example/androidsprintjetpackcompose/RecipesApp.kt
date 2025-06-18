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
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.androidsprintjetpackcompose.ui.categories.CategoriesScreen
import com.example.androidsprintjetpackcompose.ui.favorites.FavoritesScreen
import com.example.androidsprintjetpackcompose.ui.model.RecipeUiModel
import com.example.androidsprintjetpackcompose.ui.navigation.BottomNavigation
import com.example.androidsprintjetpackcompose.ui.navigation.Screen
import com.example.androidsprintjetpackcompose.ui.navigation.ScreenId
import com.example.androidsprintjetpackcompose.ui.recipedetails.RecipesDetailScreen
import com.example.androidsprintjetpackcompose.ui.recipes.RecipesScreen
import com.example.androidsprintjetpackcompose.ui.theme.AndroidSprintJetpackComposeTheme

@Composable
fun RecipesApp(modifier: Modifier = Modifier) {

    val navController = rememberNavController()

    AndroidSprintJetpackComposeTheme {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            bottomBar = {
                BottomNavigation(
                    onFavouritesClick = { navController.navigate(Screen.Favourites.route) },
                    onCategoriesClick = { navController.navigate(Screen.Categories.route) }
                )
            }
        ) { innerPadding ->
            NavHost(
                navController = navController,
                startDestination = Screen.Categories.route,
            )
            {
                composable(route = Screen.Categories.route) {
                    CategoriesScreen(
                        paddingValues = innerPadding,
                        onCategoryClick = { categoryId ->
                            navController.navigate("recipes/$categoryId")
                        }
                    )
                }
                composable(
                    route = Screen.Recipes.route,
                    arguments = listOf(navArgument("categoryId") { type = NavType.IntType })
                ) { backStackEntry ->
                    val categoryId = backStackEntry.arguments?.getInt("categoryId") ?: 0
                    RecipesScreen(
                        categoryId = categoryId,
                        paddingValues = innerPadding,
                        onRecipeClick = { recipe ->
                            navController.currentBackStackEntry?.savedStateHandle?.set("recipe", recipe)
                            navController.navigate("recipe_details")
                        }
                    )
                }
                composable(route = Screen.Favourites.route) {
                    FavoritesScreen(innerPadding)
                }
                composable(
                    route = Screen.RecipeDetails.route,
                ) {
                    val recipe = navController.previousBackStackEntry?.savedStateHandle?.get<RecipeUiModel>("recipe")
                    RecipesDetailScreen(
                        recipeUiModel = recipe,
                        paddingValues = innerPadding,
                    )
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun RecipesAppPreview() {
    RecipesApp()
}