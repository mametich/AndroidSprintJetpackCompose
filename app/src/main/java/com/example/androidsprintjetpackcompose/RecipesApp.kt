package com.example.androidsprintjetpackcompose

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
import com.example.androidsprintjetpackcompose.ui.categories.ScreenHeader
import com.example.androidsprintjetpackcompose.ui.navigation.BottomNavigation
import com.example.androidsprintjetpackcompose.ui.navigation.ScreenId
import com.example.androidsprintjetpackcompose.ui.theme.AndroidSprintJetpackComposeTheme

@Composable
fun RecipesApp(modifier: Modifier = Modifier) {

    var currentNavItem by remember { mutableStateOf(ScreenId.CATEGORIES) }

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
                ScreenId.CATEGORIES -> CategoriesScreen(innerPadding)
                ScreenId.FAVOURITES -> FavouritesScreen(innerPadding)
            }
        }
    }
}

@Composable
fun CategoriesScreen(paddingValues: PaddingValues) {
    ScreenHeader()
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = stringResource(R.string.title_category),
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
            text = stringResource(R.string.title_favourites),
            style = MaterialTheme.typography.bodyMedium
        )
    }
}


@Preview(showBackground = true)
@Composable
fun RecipesAppPreview() {
    RecipesApp()
}