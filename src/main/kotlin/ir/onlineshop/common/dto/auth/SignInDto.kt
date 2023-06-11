package ir.onlineshop.common.dto.auth

data class SignInDto(
    var username: String? = null,
    val password: String? = null
)
