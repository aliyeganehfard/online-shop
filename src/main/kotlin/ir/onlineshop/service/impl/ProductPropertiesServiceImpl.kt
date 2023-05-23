package ir.onlineshop.service.impl

import ir.onlineshop.database.model.ProductProperties
import ir.onlineshop.database.repository.ProductPropertiesRepository
import ir.onlineshop.service.ProductPropertiesService
import ir.onlineshop.service.ShopService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ProductPropertiesServiceImpl @Autowired constructor(
    val productPropertiesRepository: ProductPropertiesRepository,
    val shopService: ShopService
) : ProductPropertiesService {

    @Transactional
    override fun saveAll(productProperties: List<ProductProperties>) {
        productPropertiesRepository.saveAll(productProperties)
    }

    override fun findAllById(propertiesIds: List<Long?>?): MutableList<ProductProperties>? {
        return propertiesIds?.let { productPropertiesRepository.findAllById(it) }
    }

    override fun findShopProperties(shopId: Long): List<ProductProperties> {
        val existsShopById = shopService.existById(shopId)
        if (!existsShopById)
            throw Exception()
        return productPropertiesRepository.findShopProperties(shopId)
    }
}