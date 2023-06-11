package ir.onlineshop.service.impl

import ir.onlineshop.common.dto.auth.AuthenticationResponse
import ir.onlineshop.common.dto.auth.SignInDto
import ir.onlineshop.common.exception.OnlineShopException
import ir.onlineshop.config.security.JwtService
import ir.onlineshop.database.model.User
import ir.onlineshop.database.model.enums.UserRole
import ir.onlineshop.database.repository.UserRepository
import ir.onlineshop.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserServiceImpl @Autowired constructor(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder,
    private val jwtService: JwtService,
    private val authenticationManager: AuthenticationManager
) : UserService {

    override fun signUp(user: User): AuthenticationResponse {
        val encodedPassword = passwordEncoder.encode(user.password)
        user.password = encodedPassword
        userRepository.save(user)
        val jwt = jwtService.generateToken(user)
        return AuthenticationResponse(token = jwt)
    }

    override fun signIn(signInDto: SignInDto): AuthenticationResponse {
        authenticationManager.authenticate(
            UsernamePasswordAuthenticationToken(
                signInDto.username,
                signInDto.password
            )
        )
        val user = findByUsername(signInDto.username!!)
        val jwt = jwtService.generateToken(user)
        return AuthenticationResponse(token = jwt)
    }

    override fun findByUsername(username: String): User {
        return userRepository.findByUsername(username).orElseThrow{
            OnlineShopException("username $username not found!")
        }
    }

    override fun findById(userId: Long): User {
        return userRepository.findById(userId).orElseThrow { OnlineShopException("user with id $userId not found!") }
    }

    override fun findShopOwnerById(userId: Long): User {
        findById(userId).let {
            if (it.role!! != UserRole.SHOP_OWNER)
                throw OnlineShopException("user with id = $userId dont have SHOP_OWNER permission")
            return it
        }
    }

    override fun existById(userId: Long): Boolean {
        return userRepository.existsById(userId)
    }

}