package ir.onlineshop.service

import ir.onlineshop.database.model.Shop

interface ShopService {

    fun save(shop: Shop): Shop

    fun findAll(): List<Shop>

    fun findById(id: Long): Shop

    fun existById(id: Long): Boolean
}