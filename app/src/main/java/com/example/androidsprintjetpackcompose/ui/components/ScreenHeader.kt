package com.example.androidsprintjetpackcompose.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
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
import androidx.compose.ui.text.font.FontWeight
import com.example.androidsprintjetpackcompose.R
import com.example.androidsprintjetpackcompose.ui.theme.Dimens

/**
 * Кастомная Header с рисунком и текстом
 * @param title Текст заголовка, который будет отображаться поверх изображения
 * @param imageRes Ресурс ID фонового изображения (должен быть помечен как @DrawableRes)
 *
 * Пример использования:
 * ```
 * ScreenHeader(
 *     title = "Избранное",
 *     imageRes = R.drawable.header_background
 * )
 * ```
 *
 * @see Box Компоновка, используемая для размещения элементов
 * @see Image Компонент для отображения фонового изображения
 * @see Text Компонент для отображения заголовка
 */

@Composable
fun ScreenHeader(
    title: String,
    contentDescription: String,
    @DrawableRes imageRes: Int,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = contentDescription,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxWidth()
        )
        Text(
            text = title.uppercase(),
            modifier = Modifier
                .padding(Dimens.paddingLarge)
                .align(Alignment.BottomStart)
                .background(
                    MaterialTheme.colorScheme.surface,
                    shape = RoundedCornerShape(Dimens.paddingMedium)
                )
                .padding(Dimens.paddingMediumBeforeLarge),
            style = MaterialTheme.typography.displayLarge,
        )
    }
}