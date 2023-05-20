package ir.onlineshop.common.dto

data class CategorySaveDto(
    var id: Long? = null,
    var title: String = "",
    var parentCategoryId: Long? = null
)