package ir.onlineshop.service

import ir.onlineshop.database.repository.projections.UserFavorites

interface FavoriteService {

    fun save(userId: Long, productId: Long)

    fun findUserFavorites(userId: Long): List<UserFavorites>
}