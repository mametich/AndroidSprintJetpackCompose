package com.example.androidsprintjetpackcompose.ui.model

import android.os.Parcelable
import androidx.compose.runtime.Immutable
import com.example.androidsprintjetpackcompose.Constants
import com.example.androidsprintjetpackcompose.data.model.RecipeDto
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import kotlinx.collections.immutable.toImmutableList
import kotlinx.parcelize.Parcelize


@Immutable
@Parcelize
data class RecipeUiModel(
    val id: Int,
    val title: String,
    val imageUrl: String,
    val ingredients: ImmutableList<IngredientUiModel>,
    val method: List<String>,
) : Parcelable

fun RecipeDto.toUiModel() : RecipeUiModel {
    return RecipeUiModel(
        id = id,
        title = title,
        imageUrl = Constants.ASSETS_URI_PREFIX + imageUrl,
        ingredients = ingredients.map { it.toUiModel() }.toImmutableList(),
        method = method.toImmutableList()
    )
}

fun RecipeDto.toRecipeCardUiModel() : RecipeUiModel {
    return RecipeUiModel(
        id = id,
        title = title,
        imageUrl = Constants.ASSETS_URI_PREFIX + imageUrl,
        ingredients = persistentListOf(),
        method = persistentListOf()
    )
}