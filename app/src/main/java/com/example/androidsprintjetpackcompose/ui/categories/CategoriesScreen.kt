package com.example.androidsprintjetpackcompose.ui.categories

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.androidsprintjetpackcompose.R
import com.example.androidsprintjetpackcompose.ui.components.ScreenHeader
import com.example.androidsprintjetpackcompose.ui.theme.Dimens

@Composable
fun CategoriesScreen(paddingValues: PaddingValues) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ScreenHeader(
            title = stringResource(R.string.title_category),
            imageRes = R.drawable.bcg_categories,
            contentDescription = stringResource(R.string.title_category)
        )
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CategoriesScreenPreview(modifier: Modifier = Modifier) {
   CategoriesScreen(
       paddingValues = PaddingValues(Dimens.paddingMedium)
   )
}