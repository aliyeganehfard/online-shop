package ir.onlineshop.database.repository

import ir.onlineshop.database.model.ShopProfile
import ir.onlineshop.database.model.enums.ShopStatus
import ir.onlineshop.database.repository.projections.ShopStatusProjections
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface ShopProfileRepository : JpaRepository<ShopProfile, Long> {

    fun findByShopIdAndActive(shopId: Long, active: Boolean): MutableList<ShopProfile>

    fun findByStatusAndActive(shopStatus: ShopStatus, active: Boolean): List<ShopProfile>

    @Query("SELECT s.status FROM ShopProfile s WHERE s.active = true AND s.shop.id = :shopId")
    fun findStatusByShopId(@Param(value = "shopId") shopId: Long): ShopStatus
}