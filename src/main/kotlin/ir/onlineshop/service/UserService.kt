package ir.onlineshop.service

import ir.onlineshop.database.model.User

interface UserService {

    fun save(user: User)

    fun findById(userId: Long): User

    fun findShopOwnerById(userId: Long): User

    fun existById(userId: Long): Boolean
}