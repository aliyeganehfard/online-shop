package ir.onlineshop.service

import ir.onlineshop.database.model.ShopOwner

interface ShopOwnerService {

    fun save(shopOwner: ShopOwner)
}