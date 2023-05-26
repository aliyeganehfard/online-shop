package ir.onlineshop.service

interface FavoriteService {

    fun save(userId: Long, productId: Long)
}