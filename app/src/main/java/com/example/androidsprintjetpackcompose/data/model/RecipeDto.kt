package com.example.androidsprintjetpackcompose.data.model

data class RecipeDto(
    val id: Int,
    val imageUrl: String,
    val ingredients: List<IngredientDto>,
    val method: List<String>,
    val title: String
)