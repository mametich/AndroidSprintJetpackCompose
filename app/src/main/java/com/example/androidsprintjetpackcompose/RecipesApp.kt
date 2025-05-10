package com.example.androidsprintjetpackcompose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.androidsprintjetpackcompose.navigation.BottomNavItem
import com.example.androidsprintjetpackcompose.navigation.BottomNavigation
import com.example.androidsprintjetpackcompose.ui.theme.AndroidSprintJetpackComposeTheme

@Composable
fun RecipesApp(modifier: Modifier = Modifier) {

    var currentNavItem by remember { mutableStateOf(BottomNavItem.CATEGORIES) }

    AndroidSprintJetpackComposeTheme {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            bottomBar = {
                BottomNavigation(
                   onFavouritesClick = {},
                   onCategoriesClick = {}
                )
            }
        ) { innerPadding ->
            when (currentNavItem) {
                BottomNavItem.CATEGORIES -> CategoriesScreen(innerPadding)
                BottomNavItem.RECIPES -> RecipesScreen(innerPadding)
                BottomNavItem.FAVOURITES -> FavouritesScreen(innerPadding)

            }
        }
    }
}

@Composable
fun CategoriesScreen(paddingValues: PaddingValues) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = stringResource(R.string.category),
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

@Composable
fun RecipesScreen(paddingValues: PaddingValues) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = stringResource(R.string.recipes),
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

@Composable
fun FavouritesScreen(paddingValues: PaddingValues) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = stringResource(R.string.favourites),
            style = MaterialTheme.typography.bodyMedium
        )
    }
}


@Preview(showBackground = true)
@Composable
fun RecipesAppPreview() {
    RecipesApp()
}