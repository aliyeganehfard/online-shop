package ir.onlineshop.service.impl

import ir.onlineshop.database.model.Favorite
import ir.onlineshop.database.repository.FavoriteRepository
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
): FavoriteService {

    override fun save(userId: Long, productId: Long) {
        val user = userService.findById(userId)
        val product = productService.findById(productId)

        val favorite = Favorite().apply {
            this.user = user
            this.product = product
        }

        favoriteRepository.save(favorite)
    }

}