package ir.onlineshop.service

import ir.onlineshop.common.dto.auth.AuthenticationResponse
import ir.onlineshop.common.dto.auth.SignInDto
import ir.onlineshop.database.model.User

interface UserService {

    fun signUp(user: User): AuthenticationResponse

    fun signIn(signInDto: SignInDto): AuthenticationResponse

    fun findByUsername(username: String): User

    fun findById(userId: Long): User

    fun findShopOwnerById(userId: Long): User

    fun existById(userId: Long): Boolean
}