package ir.onlineshop.service.impl

import ir.onlineshop.common.exception.OnlineShopException
import ir.onlineshop.database.model.Favorite
import ir.onlineshop.database.repository.FavoriteRepository
import ir.onlineshop.database.repository.projections.UserFavorites
import ir.onlineshop.service.FavoriteService
import ir.onlineshop.service.ProductService
import ir.onlineshop.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class FavoriteServiceImpl @Autowired constructor(
    private val favoriteRepository: FavoriteRepository,
    private val userService: UserService,
    private val productService: ProductService
) : FavoriteService {

    override fun save(userId: Long, productId: Long) {
        val user = userService.findById(userId)
        val product = productService.findById(productId)

        val favorite = Favorite().apply {
            this.user = user
            this.product = product
        }

        favoriteRepository.save(favorite)
    }

    override fun findUserFavorites(userId: Long): List<UserFavorites> {
        userService.existById(userId).let {
            if (!it)
                throw OnlineShopException("user with id $userId not found!")
            return favoriteRepository.findAllByUserId(userId)
        }
    }

    override fun deleteById(favoriteId: Long) {
        existById(favoriteId).let {
            if (!it)
                throw OnlineShopException("favorite with id $favoriteId not found!")
            favoriteRepository.deleteById(favoriteId)
        }
    }

    private fun existById(favoriteId: Long): Boolean {
        return favoriteRepository.existsById(favoriteId)
    }

}