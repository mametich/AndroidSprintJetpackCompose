package com.example.androidsprintjetpackcompose.ui.model

import androidx.compose.runtime.Immutable
import com.example.androidsprintjetpackcompose.data.model.IngredientDto

@Immutable
data class IngredientUiModel(
    val description: String,
    val quantity: String,
    val unitOfMeasure: String
)

fun IngredientDto.toUiModel() : IngredientUiModel {
    return IngredientUiModel(
        description = description,
        quantity = quantity,
        unitOfMeasure = unitOfMeasure
    )
}
