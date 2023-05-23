package ir.onlineshop.database.repository

import ir.onlineshop.database.model.Product
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ProductRepository : JpaRepository<Product, Long> {

    fun findAllByShopId(shopId: Long): List<Product>

}