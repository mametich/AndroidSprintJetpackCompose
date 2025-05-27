package com.example.androidsprintjetpackcompose.data.model

data class RecipeDto(
    val id: Int,
    val title: String,
    val imageUrl: String,
    val ingredients: List<IngredientDto>,
    val method: List<String>,
)