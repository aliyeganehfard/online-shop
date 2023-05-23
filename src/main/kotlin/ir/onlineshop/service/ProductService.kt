package ir.onlineshop.service

import ir.onlineshop.database.model.Product

interface ProductService {

    fun save(product: Product)
}