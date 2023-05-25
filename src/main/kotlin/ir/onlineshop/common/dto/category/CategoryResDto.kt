package ir.onlineshop.common.dto.category

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude

@JsonInclude(JsonInclude.Include.NON_NULL)
data class CategoryResDto(
    var id: Long? = null,
    var title: String? = null,

    @JsonIgnoreProperties("childCategories")
    var parentCategory: CategoryResDto? = null,

    @JsonIgnoreProperties("parentCategory")
    var childCategories: MutableList<CategoryResDto>? = null
)
