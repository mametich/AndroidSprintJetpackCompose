package com.example.androidsprintjetpackcompose.ui.recipes

import androidx.annotation.DrawableRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import com.example.androidsprintjetpackcompose.R
import com.example.androidsprintjetpackcompose.data.repository.RecipesRepositoryStub
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
        modifier = modifier
            .padding(paddingValues)
    ) {
        ScreenHeader(
            title = stringResource(R.string.title_burgers),
            imageRes = R.drawable.burger,
            contentDescription = stringResource(R.string.title_burgers)
        )
        LazyColumn(
            contentPadding = PaddingValues(Dimens.paddingLarge)
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