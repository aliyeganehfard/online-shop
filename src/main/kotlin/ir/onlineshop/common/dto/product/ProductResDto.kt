package ir.onlineshop.common.dto.product

import ir.onlineshop.common.dto.productProperties.ProductPropertiesDto
import ir.onlineshop.common.dto.productProperties.ProductPropertiesIdHolder
import ir.onlineshop.common.dto.shop.ShopIdHolderDto

data class ProductResDto(
    var name: String = "",
    var description: String = "",
    var price: Long = 0,
    var properties: List<ProductPropertiesDto>? = null
)
