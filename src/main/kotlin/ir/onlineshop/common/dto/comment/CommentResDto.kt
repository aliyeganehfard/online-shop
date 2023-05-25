package ir.onlineshop.common.dto.comment

import ir.onlineshop.database.model.enums.CommentScore
import java.time.LocalDateTime

data class CommentResDto(
    var comment: String? = null,
    var score: CommentScore? = null,
    var createDate: LocalDateTime? = null,
)
