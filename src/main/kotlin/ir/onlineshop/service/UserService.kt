package ir.onlineshop.service

import ir.onlineshop.database.model.User

interface UserService {

    fun save(user: User)
}