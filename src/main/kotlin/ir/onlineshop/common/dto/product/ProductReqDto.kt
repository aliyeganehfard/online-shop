package ir.onlineshop.common.dto.product

import ir.onlineshop.common.dto.shop.ShopDto
import ir.onlineshop.common.dto.shop.ShopProductsReqDto

data class ProductReqDto(
    var name: String = "",
    var description: String = "",
    var price: Long = 0,
    var properties: List<ProductPropertiesDto>? = null,
    var shop: ShopProductsReqDto? = null
)
