package ir.onlineshop.service

import ir.onlineshop.database.model.Shop
import ir.onlineshop.database.model.ShopProfile
import ir.onlineshop.database.model.enums.ShopStatus

interface ShopProfileService {

    fun save(shop: Shop, shopStatus: ShopStatus)

    fun findShopsWithAwaitingConfirmationsStatus(): List<ShopProfile>

    fun confirmShopRequest(shopId: Long) : Boolean

    fun findByShopId(shopId: Long)
}