package ir.onlineshop.common.dto.product

import ir.onlineshop.common.dto.category.CategoryIdHolderDto
import ir.onlineshop.common.dto.category.CategoryReqDto
import ir.onlineshop.common.dto.productProperties.ProductPropertiesIdHolder
import ir.onlineshop.common.dto.shop.ShopIdHolderDto

data class ProductReqDto(
    var name: String = "",
    var description: String = "",
    var price: Long = 0,
    var properties: List<ProductPropertiesIdHolder>? = null,
    var shop: ShopIdHolderDto? = null,
    var category: CategoryIdHolderDto? = null
)
