package ir.onlineshop.common.dto.productProperties

import ir.onlineshop.common.dto.product.ProductIdHolderDto

data class ProductPropertiesDto(
    var title: String? = null,
    var value: String? = null,
    var product: ProductIdHolderDto? = null
)
