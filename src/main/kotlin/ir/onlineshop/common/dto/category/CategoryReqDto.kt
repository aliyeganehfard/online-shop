package ir.onlineshop.common.dto.category

data class CategoryReqDto(
    var title: String = "",
    var parentCategory: CategoryReqDto? = null
)