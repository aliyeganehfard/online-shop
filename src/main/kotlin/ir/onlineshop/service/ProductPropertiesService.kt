package ir.onlineshop.service

import ir.onlineshop.database.model.ProductProperties
import ir.onlineshop.database.model.Shop

interface ProductPropertiesService {

    fun saveAll(productProperties: List<ProductProperties>)

    fun findAllById(propertiesIds: List<Long?>?): MutableList<ProductProperties>?
}