package ir.onlineshop.service

import ir.onlineshop.database.model.Shop
import ir.onlineshop.database.model.enums.ShopStatus

interface ShopProfileService {

    fun save(shop: Shop, shopStatus: ShopStatus)

    fun findByShopId(shopId: Long)
}