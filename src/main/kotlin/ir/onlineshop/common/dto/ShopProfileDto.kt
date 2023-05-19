package ir.onlineshop.common.dto

import ir.onlineshop.database.model.enums.ShopStatus
import java.time.LocalDateTime

data class ShopProfileDto(

    var statusStartDate: LocalDateTime? =null,
    var statusEndDate: LocalDateTime? = null,
    var active: Boolean? =null,
    var status: ShopStatus? = null,

    var shopId: Long? = null,
    var shopName: String = "",
    var shopLatinName: String = "",
    var shopAbout: String? = "",
    var shopAddress: String? = "",
)
