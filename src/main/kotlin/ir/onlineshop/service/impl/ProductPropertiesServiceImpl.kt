package ir.onlineshop.service.impl

import ir.onlineshop.database.model.ProductProperties
import ir.onlineshop.database.repository.ProductPropertiesRepository
import ir.onlineshop.service.ProductPropertiesService
import ir.onlineshop.service.ProductService
import ir.onlineshop.service.ShopService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Lazy
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ProductPropertiesServiceImpl @Autowired constructor(
    val productPropertiesRepository: ProductPropertiesRepository,
    val shopService: ShopService,
    @Lazy val productService: ProductService,
) : ProductPropertiesService {

    override fun save(productProperties: ProductProperties) {
        val product = productService.findById(productProperties.product?.id!!)
        productProperties.product = product
        productPropertiesRepository.save(productProperties)
    }

    @Transactional
    override fun saveAll(productProperties: List<ProductProperties>) {
        productPropertiesRepository.saveAll(productProperties)
    }

    @Transactional
    override fun update(propertiesId: Long, value: String) {
        val properties = findById(propertiesId)
        properties.value = value
        productPropertiesRepository.save(properties)
    }

    override fun findById(propertiesId: Long): ProductProperties {
        return productPropertiesRepository.findById(propertiesId).orElseThrow{ (throw Exception(propertiesId.toString())) }
    }

    override fun findAllByIds(propertiesIds: List<Long?>?): MutableList<ProductProperties>? {
        return propertiesIds?.let { productPropertiesRepository.findAllById(it) }
    }

    override fun findShopProperties(shopId: Long): List<ProductProperties> {
        val existsShopById = shopService.existById(shopId)
        if (!existsShopById)
            throw Exception()
        return productPropertiesRepository.findShopProperties(shopId)
    }
}