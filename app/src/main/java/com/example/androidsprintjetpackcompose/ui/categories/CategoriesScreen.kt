package com.example.androidsprintjetpackcompose.ui.categories

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import com.example.androidsprintjetpackcompose.R
import com.example.androidsprintjetpackcompose.ui.theme.Dimens

@Composable
fun ScreenHeader(modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Image(
            painter = painterResource(R.drawable.bcg_categories),
            contentDescription = stringResource(R.string.title_category),
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxWidth()
        )
        Text(
            text = stringResource(R.string.title_category).uppercase(),
            modifier = Modifier
                .padding(Dimens.paddingLarge)
                .align(Alignment.BottomStart)
                .background(
                    MaterialTheme.colorScheme.surface,
                    shape = RoundedCornerShape(Dimens.paddingMedium)
                    )
                .padding(Dimens.paddingMediumBeforeLarge)
            ,
            style = MaterialTheme.typography.displayLarge
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ScreenHeaderPreview(modifier: Modifier = Modifier) {
    ScreenHeader()
}