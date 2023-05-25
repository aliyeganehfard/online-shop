package ir.onlineshop.common.dto.comment

import ir.onlineshop.common.dto.product.ProductIdHolderDto
import ir.onlineshop.database.model.enums.CommentScore

data class CommentReqDto(
    var comment: String? = null,
    var score: CommentScore? = null,
    var product: ProductIdHolderDto? = null
)
