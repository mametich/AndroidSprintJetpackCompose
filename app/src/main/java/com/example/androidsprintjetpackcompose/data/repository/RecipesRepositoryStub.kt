package com.example.androidsprintjetpackcompose.data.repository

import com.example.androidsprintjetpackcompose.data.model.CategoryDto
import com.example.androidsprintjetpackcompose.data.model.IngredientDto
import com.example.androidsprintjetpackcompose.data.model.RecipeDto

object RecipesRepositoryStub {

    val categories = listOf(
        CategoryDto(0, "Бургеры", "Рецепты всех популярных видов бургеров", "burger.png"),
        CategoryDto(1, "Десерты", "Самые вкусные рецепты десертов специально для вас", "dessert.png"),
        CategoryDto(2, "Пицца", "Пицца на любой вкус и цвет. Лучшая подборка для тебя", "pizza.png"),
        CategoryDto(3, "Рыба", "Печеная, жареная, сушеная, любая рыба на твой вкус", "fish.png"),
        CategoryDto(4, "Супы", "От классики до экзотики: мир в одной тарелке", "soup.png"),
        CategoryDto(5, "Салаты", "Хрустящий калейдоскоп под соусом вдохновения", "salad.png"),
    )

    private val recipes = listOf(
        RecipeDto(
            id = 0,
            title = "Классический бургер с говядиной",
            ingredients = listOf(
                IngredientDto("0.5", "кг", "говяжий фарш"),
                IngredientDto("1.0", "шт", "луковица, мелко нарезанная"),
                IngredientDto("2.0", "зубч", "чеснок, измельченный"),
                IngredientDto("4.0", "шт", "булочки для бургера"),
                IngredientDto("4.0", "шт", "листа салата"),
                IngredientDto("1.0", "шт", "помидор, нарезанный кольцами"),
                IngredientDto("2.0", "ст. л.", "горчица"),
                IngredientDto("2.0", "ст. л.", "кетчуп"),
                IngredientDto("по вкусу", "", "соль и черный перец")
            ),
            imageUrl = "burger.png",
            method = listOf(
                "1. В глубокой миске смешайте говяжий фарш, лук, чеснок, соль и перец. Разделите фарш на 4 равные части и сформируйте котлеты.",
                "2. Разогрейте сковороду на среднем огне. Обжаривайте котлеты с каждой стороны в течение 4-5 минут или до желаемой степени прожарки.",
                "3. В то время как котлеты готовятся, подготовьте булочки. Разрежьте их пополам и обжарьте на сковороде до золотистой корочки.",
                "4. Смазать нижние половинки булочек горчицей и кетчупом, затем положите лист салата, котлету, кольца помидора и закройте верхней половинкой булочки.",
                "5. Подавайте бургеры горячими с картофельными чипсами или картофельным пюре."
            ),
        )
    )

    fun getAllCategories(): List<CategoryDto> = categories

    fun getRecipes(categoryId: Int): List<RecipeDto> {
        return if (categoryId == 0) recipes else emptyList()
    }

}