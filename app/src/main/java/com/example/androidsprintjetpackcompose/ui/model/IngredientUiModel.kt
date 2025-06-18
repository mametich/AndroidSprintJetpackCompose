package com.example.androidsprintjetpackcompose.ui.model

import android.os.Parcelable
import androidx.compose.runtime.Immutable
import com.example.androidsprintjetpackcompose.data.model.IngredientDto
import kotlinx.parcelize.Parcelize

@Parcelize
@Immutable
data class IngredientUiModel(
    val description: String,
    val quantity: String,
    val unitOfMeasure: String
) : Parcelable

fun IngredientDto.toUiModel() : IngredientUiModel {
    return IngredientUiModel(
        description = description,
        quantity = quantity,
        unitOfMeasure = unitOfMeasure
    )
}
