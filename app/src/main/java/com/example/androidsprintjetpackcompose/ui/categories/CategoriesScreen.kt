package com.example.androidsprintjetpackcompose.ui.categories

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import com.example.androidsprintjetpackcompose.Constants
import com.example.androidsprintjetpackcompose.R
import com.example.androidsprintjetpackcompose.data.repository.RecipesRepositoryStub
import com.example.androidsprintjetpackcompose.ui.components.ScreenHeader
import com.example.androidsprintjetpackcompose.ui.model.CategoryUiModel
import com.example.androidsprintjetpackcompose.ui.model.toUiModel
import com.example.androidsprintjetpackcompose.ui.theme.Dimens

@Composable
fun CategoriesScreen(
    paddingValues: PaddingValues,
    onCategoryClick: (CategoryUiModel) -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ScreenHeader(
            title = stringResource(R.string.title_category),
            imageRes = R.drawable.bcg_categories,
            contentDescription = stringResource(R.string.title_category)
        )
        CategoryList(
            categories = RecipesRepositoryStub.getAllCategories().map { it.toUiModel() },
            onCategoryClick = onCategoryClick,

            )
    }
}

@Composable
fun CategoryList(
    categories: List<CategoryUiModel>,
    onCategoryClick: (CategoryUiModel) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier
            .fillMaxSize(),
        contentPadding = PaddingValues(Dimens.paddingMedium),
    ) {
        items(categories) { category ->
            CategoryItem(
                category = category,
                onClick = { onCategoryClick(category) }
            )
        }
    }
}


@Composable
fun CategoryItem(
    category: CategoryUiModel,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(Dimens.paddingMedium)
            .clickable(onClick = onClick),
        elevation = CardDefaults.cardElevation(
            defaultElevation = Dimens.paddingSmall
        ),
        shape = MaterialTheme.shapes.medium,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface,
        )
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(Dimens.paddingMedium)
        ) {
            AsyncImage(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(Dimens.paddingImageLarge),
                model = ImageRequest.Builder(LocalContext.current)
                    .data(category.imageUrl)
                    .crossfade(true)
                    .build(),
                contentDescription = category.title,
                contentScale = ContentScale.Crop
            )
            Text(
                modifier = Modifier.padding(
                    start = Dimens.paddingMedium,
                ),
                text = category.title.uppercase(),
                style = MaterialTheme.typography.bodyMedium,
            )
            Text(
                modifier = Modifier.padding(
                    start = Dimens.paddingMedium,
                    bottom = Dimens.paddingMedium,
                    end = Dimens.paddingMedium
                ),
                text = category.description,
                style = MaterialTheme.typography.bodySmall,
                maxLines = 3,
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun CategoriesScreenPreview(modifier: Modifier = Modifier) {
    CategoryList(
        categories = RecipesRepositoryStub.getAllCategories().map { it.toUiModel() },
        onCategoryClick = {}
    )
}