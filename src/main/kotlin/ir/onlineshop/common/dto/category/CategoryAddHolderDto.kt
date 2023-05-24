package ir.onlineshop.common.dto.category

data class CategoryAddHolderDto(
    var parentId: Long? = null,
    var title: String? = null
)
