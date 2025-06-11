package com.example.androidsprintjetpackcompose.ui.categories

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import com.example.androidsprintjetpackcompose.ui.model.CategoryUiModel
import com.example.androidsprintjetpackcompose.ui.theme.Dimens

@Composable
fun CategoryItem(
    category: CategoryUiModel,
    modifier: Modifier = Modifier,
    onClick: (Int) -> Unit,
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(Dimens.paddingMedium)
            .clickable { onClick(category.id) },
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