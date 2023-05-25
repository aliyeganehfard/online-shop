package ir.onlineshop.service

import ir.onlineshop.database.model.ProductProperties

interface ProductPropertiesService {

    fun save(productProperties: ProductProperties)

    fun saveAll(productProperties: List<ProductProperties>)

    fun update(propertiesId: Long, value: String)

    fun deleteById(propertiesId: Long)

    fun findById(propertiesId: Long): ProductProperties

    fun findAllByIds(propertiesIds: List<Long?>?): MutableList<ProductProperties>?

    fun findShopProperties(shopId: Long): List<ProductProperties>

}