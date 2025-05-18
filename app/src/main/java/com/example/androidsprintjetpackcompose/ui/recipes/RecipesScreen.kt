package com.example.androidsprintjetpackcompose.ui.recipes

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.androidsprintjetpackcompose.R
import com.example.androidsprintjetpackcompose.ui.components.ScreenHeader

@Composable
fun RecipesScreen(
    title: String,
    @DrawableRes imageRes: Int,
    modifier: Modifier = Modifier
) {
    ScreenHeader(
        title = stringResource(R.string.title_recipes),
        imageRes = R.drawable.bcg_categories,
        contentDescription = stringResource(R.string.title_recipes)
    )
}