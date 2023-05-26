package ir.onlineshop.common.dto.shop

import ir.onlineshop.common.dto.category.CategoryIdHolderDto
import ir.onlineshop.common.dto.user.UserIdHolderDto

data class ShopReqDto(
    var name: String? = null,
    var latinName: String? = null,
    var about: String? = null,
    var address: String? = null,
    var category: CategoryIdHolderDto? = null,
    var shopOwner: UserIdHolderDto? = null
)
