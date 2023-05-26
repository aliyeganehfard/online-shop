package ir.onlineshop.service.impl

import ir.onlineshop.common.exception.OnlineShopException
import ir.onlineshop.database.model.User
import ir.onlineshop.database.model.enums.UserRole
import ir.onlineshop.database.repository.UserRepository
import ir.onlineshop.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserServiceImpl @Autowired constructor(
    private val userRepository: UserRepository
) : UserService {

    override fun save(user: User) {
        userRepository.save(user)
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