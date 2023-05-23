package ir.onlineshop.common.dto.category

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

data class CategoryResDto(
    var id: Long? = null,
    var title: String? = null,

    @JsonIgnoreProperties("childCategories")
    var parentCategory: CategoryResDto? = null,

    @JsonIgnoreProperties("parentCategory")
    var childCategories: MutableList<CategoryResDto>? = null
)
