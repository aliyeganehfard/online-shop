package ir.onlineshop.common.dto.productProperties

import ir.onlineshop.common.dto.product.ProductIdHolderDto

data class ProductPropertiesReqDto(
    var title: String? = null,
    var value: String? = null,
    var product: ProductIdHolderDto? = null
)
