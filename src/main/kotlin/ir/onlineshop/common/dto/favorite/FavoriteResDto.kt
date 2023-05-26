package ir.onlineshop.common.dto.favorite

data class FavoriteResDto(
    var productId: Long? = null,
    var productName: String? = null,
    var productPrice: Long? = null,
    var shopName: String? = null,
)
