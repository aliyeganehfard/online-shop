package ir.onlineshop.common.dto

import ir.onlineshop.database.model.Category

data class CategorySaveDto(
    var id: Long? = null,
    var title: String = "",
    var parentCategory: Category? = null
)