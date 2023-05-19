package ir.onlineshop.database.repository

import ir.onlineshop.database.model.ShopProfile
import ir.onlineshop.database.model.enums.ShopStatus
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ShopProfileRepository: JpaRepository<ShopProfile,Long> {

    fun findByShopIdAndActive(shopId: Long, Active: Boolean) : MutableList<ShopProfile>

    fun findByStatus(shopStatus: ShopStatus) : List<ShopProfile>
}