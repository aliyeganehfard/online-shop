package ir.onlineshop.common.dto.shop

import java.time.LocalDateTime

data class ShopDto(
    var name: String = "",
    var latinName: String = "",
    var about: String? = "",
    var address: String? = "",
    var createDate: LocalDateTime? = null,
    var updateDate: LocalDateTime? = null,
)
