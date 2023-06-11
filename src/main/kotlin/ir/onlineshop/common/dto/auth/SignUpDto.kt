package ir.onlineshop.common.dto.auth

import ir.onlineshop.database.model.enums.UserRole

data class SignUpDto(
    var username: String? = null,
    var password: String? = null,
    var firstname: String? = null,
    var lastname: String? = null,
    var phoneNumber: String? = null,
    var email: String? = null,
    var role: UserRole? = null,
)
