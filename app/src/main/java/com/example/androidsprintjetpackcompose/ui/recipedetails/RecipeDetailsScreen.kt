package com.example.androidsprintjetpackcompose.ui.recipedetails

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.androidsprintjetpackcompose.ui.components.ScreenHeader
import com.example.androidsprintjetpackcompose.ui.model.RecipeUiModel
import com.example.androidsprintjetpackcompose.R

@Composable
fun RecipesDetailScreen(
    recipeUiModel: RecipeUiModel?,
    paddingValues: PaddingValues,
    modifier: Modifier = Modifier
) {
    if (recipeUiModel == null) {
        Box(
            modifier = modifier
                .fillMaxSize()
                .padding(paddingValues),
            contentAlignment = Alignment.Center
        ) {
            Text("Ошибка: рецепт не найден")
        }
        return
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ScreenHeader(
            title = recipeUiModel?.title?.uppercase() ?: "",
            contentDescription = recipeUiModel?.title ?: "",
            imageUrl = recipeUiModel?.imageUrl ?: ""
        )
    }
}