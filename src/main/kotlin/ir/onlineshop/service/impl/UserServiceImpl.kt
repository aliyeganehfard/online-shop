package ir.onlineshop.service.impl

import ir.onlineshop.database.model.User
import ir.onlineshop.database.repository.UserRepository
import ir.onlineshop.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserServiceImpl @Autowired constructor(
    private val userRepository: UserRepository
): UserService {

    override fun save(user: User) {
        userRepository.save(user)
    }

}