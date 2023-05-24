package ir.onlineshop.service

import ir.onlineshop.database.model.Product

interface ProductService {

    fun save(product: Product)

    fun findShopProducts(shopId: Long): List<Product>

    fun findAll(): List<Product>
}