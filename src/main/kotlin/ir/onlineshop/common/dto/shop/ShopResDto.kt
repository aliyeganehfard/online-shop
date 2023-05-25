package ir.onlineshop.common.dto.shop

import ir.onlineshop.common.dto.category.MainCategoryDto
import java.time.LocalDateTime

data class ShopResDto(
    var name: String = "",
    var latinName: String = "",
    var about: String? = "",
    var address: String? = "",
    var createDate: LocalDateTime? = null,
    var category: MainCategoryDto? = null
)
