package ir.onlineshop.common.dto

import com.fasterxml.jackson.annotation.JsonInclude
import ir.onlineshop.database.model.enums.ShopStatus
import java.time.LocalDateTime

@JsonInclude(JsonInclude.Include.NON_NULL)
data class ShopProfileDto(

    var statusStartDate: LocalDateTime? =null,
    var active: Boolean? =null,
    var status: ShopStatus? = null,
    var statusEndDate: LocalDateTime? = null,

    var shopId: Long? = null,
    var shopName: String = "",
    var shopLatinName: String = "",
    var shopAbout: String? = "",
    var shopAddress: String? = "",
)
