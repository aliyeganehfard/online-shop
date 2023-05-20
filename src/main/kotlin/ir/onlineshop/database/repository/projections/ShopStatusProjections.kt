package ir.onlineshop.database.repository.projections

import ir.onlineshop.database.model.enums.ShopStatus

interface ShopStatusProjections {
    fun getStatus() : ShopStatus
}