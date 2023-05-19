package ir.onlineshop.database.repository

import ir.onlineshop.database.model.ShopProfile
import ir.onlineshop.database.model.enums.ShopStatus
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ShopProfileRepository: JpaRepository<ShopProfile,Long> {

    fun findByShopIdAndActive(shopId: Long, active: Boolean) : MutableList<ShopProfile>

    fun findByStatusAndActive(shopStatus: ShopStatus, active: Boolean) : List<ShopProfile>
}