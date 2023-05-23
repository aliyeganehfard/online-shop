package ir.onlineshop.database.repository

import ir.onlineshop.database.model.ProductProperties
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface ProductPropertiesRepository: JpaRepository<ProductProperties,Long>{

    @Query("SELECT p.properties FROM Product p WHERE p.shop.id = :shopId")
    fun findShopProperties(@Param("shopId") shopId: Long): List<ProductProperties>
}