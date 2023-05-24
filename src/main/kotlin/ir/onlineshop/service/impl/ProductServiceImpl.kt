package ir.onlineshop.service.impl

import ir.onlineshop.database.model.Product
import ir.onlineshop.database.repository.ProductRepository
import ir.onlineshop.service.CategoryService
import ir.onlineshop.service.ProductPropertiesService
import ir.onlineshop.service.ProductService
import ir.onlineshop.service.ShopService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ProductServiceImpl @Autowired constructor(
    private val productRepository: ProductRepository,
    private val shopService: ShopService,
    private val productPropertiesService: ProductPropertiesService,
    private val categoryService: CategoryService
) : ProductService {

    @Transactional
    override fun save(product: Product) {
        val shop = shopService.findById(product.shop?.id!!)
        val category = categoryService.findById(product.category?.id!!)

        val propertiesIds: List<Long?> = findPropertiesByIds(product)
        val properties = productPropertiesService.findAllById(propertiesIds)

        product.shop = shop
        product.category = category
        product.properties = properties!!
        productRepository.save(product)
    }

    override fun findShopProducts(shopId: Long): List<Product> {
        val isExistShopById = shopService.existById(shopId)
        if (!isExistShopById)
            throw Exception()
        return productRepository.findAllByShopId(shopId)
    }

    private fun findPropertiesByIds(product: Product): List<Long?> {
        return product.properties.asSequence()
            .map { properties -> properties.id }
            .toList()
    }

}