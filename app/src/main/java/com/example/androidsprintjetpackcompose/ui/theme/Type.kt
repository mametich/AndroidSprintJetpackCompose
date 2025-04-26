package com.example.androidsprintjetpackcompose.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
)

val recipesAppTypography = Typography(
    displayLarge = TextStyle(
        fontFamily = MontserratAlternates,
        fontWeight = FontWeight.SemiBold,
        fontSize = 20.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = MontserratAlternates,
        fontWeight = FontWeight.SemiBold,
        fontSize = 14.sp
    ),
    bodySmall = TextStyle(
        fontFamily = MontserratAlternates,
        fontWeight = FontWeight.Medium,
        fontSize = 12.sp
    ),
    labelLarge = TextStyle(
        fontFamily = MontserratAlternates,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
    ),
    labelMedium = TextStyle(
        fontFamily = MontserratAlternates,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    ),
    labelSmall = TextStyle(
        fontFamily = MontserratAlternates,
        fontWeight = FontWeight.Light,
        fontSize = 12.sp
    )
)