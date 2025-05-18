package com.example.androidsprintjetpackcompose.ui.favorites

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.androidsprintjetpackcompose.R
import com.example.androidsprintjetpackcompose.ui.components.ScreenHeader
import com.example.androidsprintjetpackcompose.ui.theme.Dimens

@Composable
fun FavoritesScreen(
    paddingValues: PaddingValues
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ScreenHeader(
            title = stringResource(R.string.title_favourites),
            imageRes = R.drawable.bcg_favorites,
            contentDescription = stringResource(R.string.title_favourites)
        )
        Spacer(modifier = Modifier.height(Dimens.paddingExtraLargest))
        Text(
            text = stringResource(R.string.text_without_recipes),
            style = MaterialTheme.typography.labelLarge,
            textAlign = TextAlign.Center
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun FavoriteScreenPreview() {
    FavoritesScreen(
        paddingValues = PaddingValues(Dimens.paddingMedium)
    )
}