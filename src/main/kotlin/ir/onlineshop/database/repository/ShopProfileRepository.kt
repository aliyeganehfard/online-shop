package ir.onlineshop.database.repository

import ir.onlineshop.database.model.ShopProfile
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ShopProfileRepository: JpaRepository<ShopProfile,Long> {

    fun findByShopIdAndActive(shopId: Long, Active: Boolean) : MutableList<ShopProfile>
}