package ir.onlineshop.service

import ir.onlineshop.database.model.ProductProperties

interface ProductPropertiesService {

    fun saveAll(productProperties: List<ProductProperties>)
}