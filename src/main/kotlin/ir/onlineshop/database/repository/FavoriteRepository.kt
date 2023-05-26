package ir.onlineshop.database.repository

import ir.onlineshop.database.model.Favorite
import ir.onlineshop.database.repository.projections.UserFavorites
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface FavoriteRepository : JpaRepository<Favorite, Long> {

    @Query("SELECT NEW ir.onlineshop.database.repository.projections" +
            ".UserFavorites(f.product.id,f.product.name,f.product.price,f.product.shop.name) " +
            "FROM Favorite f WHERE f.user.id = :userId")
    fun findAllByUserId(@Param(value = "userId") userId: Long): List<UserFavorites>
}