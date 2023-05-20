package ir.onlineshop.common.dto

import ir.onlineshop.database.model.Category

data class CategoryDto(
    var id: Long? = null,
    var title: String? = null,
    var parentCategory: Category? = null,
    var childCategories: MutableList<Category>? = null
)
