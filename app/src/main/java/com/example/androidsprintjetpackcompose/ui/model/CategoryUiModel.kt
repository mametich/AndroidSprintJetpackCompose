package com.example.androidsprintjetpackcompose.ui.model

import androidx.compose.runtime.Immutable
import com.example.androidsprintjetpackcompose.Constants
import com.example.androidsprintjetpackcompose.data.model.CategoryDto

@Immutable
data class CategoryUiModel(
    val id: Int,
    val imageUrl: String,
    val title: String,
    val description: String,
)

fun CategoryDto.toUiModel() : CategoryUiModel {
    return CategoryUiModel(
        id = id,
        imageUrl = Constants.ASSETS_URI_PREFIX + imageUrl,
        title = title,
        description = description
    )
}
