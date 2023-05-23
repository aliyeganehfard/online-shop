package ir.onlineshop.service

import ir.onlineshop.database.model.ProductProperties

interface ProductPropertiesService {

    fun saveAll(productProperties: List<ProductProperties>)

    fun findAllById(propertiesIds: List<Long?>?): MutableList<ProductProperties>?

    fun findShopProperties(shopId: Long): List<ProductProperties>
}