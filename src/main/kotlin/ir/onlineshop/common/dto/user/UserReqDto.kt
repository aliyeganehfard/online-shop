package ir.onlineshop.common.dto.user

import ir.onlineshop.database.model.enums.UserRole

data class UserReqDto(
    var username: String? = null,
    var password: String? = null,
    var firstname: String? = null,
    var lastname: String? = null,
    var phoneNumber: String? = null,
    var email: String? = null,
    var role: UserRole? = null,
)