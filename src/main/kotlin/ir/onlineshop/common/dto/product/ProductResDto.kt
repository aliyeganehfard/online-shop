package ir.onlineshop.common.dto.product

import com.fasterxml.jackson.annotation.JsonInclude
import ir.onlineshop.common.dto.comment.CommentResDto
import ir.onlineshop.common.dto.productProperties.ProductPropertiesDto

@JsonInclude(JsonInclude.Include.NON_NULL)
data class ProductResDto(
    var name: String? = null,
    var description: String? = null,
    var price: Long? = null,
    var properties: List<ProductPropertiesDto>? = null,
    var categoryTitle: String? = null,
    var comments: List<CommentResDto>? = null
)
