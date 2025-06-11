package com.example.androidsprintjetpackcompose.ui.recipes

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androidsprintjetpackcompose.R
import com.example.androidsprintjetpackcompose.data.repository.RecipesRepositoryStub.getRecipesByCategoryId
import com.example.androidsprintjetpackcompose.ui.components.ScreenHeader
import com.example.androidsprintjetpackcompose.ui.model.RecipeUiModel
import com.example.androidsprintjetpackcompose.ui.model.toUiModel
import com.example.androidsprintjetpackcompose.ui.theme.Dimens

@Composable
fun RecipesScreen(
    categoryId: Int?,
    paddingValues: PaddingValues,
    modifier: Modifier = Modifier,
    onRecipeClick: (Int) -> Unit
) {

    var recipes by remember { mutableStateOf<List<RecipeUiModel>>(emptyList()) }

    LaunchedEffect(categoryId) {
        categoryId?.let {
            recipes = getRecipesByCategoryId(it).map { dto -> dto.toUiModel() }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ScreenHeader(
            title = stringResource(R.string.title_burgers),
            imageRes = R.drawable.burger,
            contentDescription = stringResource(R.string.title_burgers),
        )
        LazyColumn(
            contentPadding = PaddingValues(Dimens.paddingLarge),
            verticalArrangement = Arrangement.spacedBy(Dimens.paddingLarge)
        ) {
            items(recipes) { recipe ->
                RecipeItem(
                    recipe = recipe,
                    onClick = onRecipeClick
                )
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun RecipesScreenPreview() {
    RecipesScreen(
        categoryId = 0,
        paddingValues = PaddingValues(Dimens.paddingMedium),
        modifier = Modifier,
        onRecipeClick = { }
    )
}