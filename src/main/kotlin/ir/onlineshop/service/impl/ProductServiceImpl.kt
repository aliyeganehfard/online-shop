package ir.onlineshop.service.impl

import ir.onlineshop.common.exception.OnlineShopException
import ir.onlineshop.database.model.Category
import ir.onlineshop.database.model.Product
import ir.onlineshop.database.model.ProductProperties
import ir.onlineshop.database.model.Shop
import ir.onlineshop.database.model.enums.ShopStatus
import ir.onlineshop.database.repository.ProductRepository
import ir.onlineshop.service.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ProductServiceImpl @Autowired constructor(
    private val productRepository: ProductRepository,
    private val shopService: ShopService,
    private val productPropertiesService: ProductPropertiesService,
    private val categoryService: CategoryService,
    private val shopProfileService: ShopProfileService
) : ProductService {

    @Transactional
    override fun save(product: Product) {
        val shop = findShopById(product)
        val category = findCategoryById(product)
        val properties = findProductPropertiesByIds(product)

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

    override fun findAll(): List<Product> {
        return productRepository.findAll()
    }

    override fun findById(productId: Long): Product {
        return productRepository.findById(productId)
            .orElseThrow{ (throw OnlineShopException("product with id $productId not found!")) }
    }

    private fun findProductPropertiesByIds(product: Product): MutableList<ProductProperties>? {
        val propertiesIds: List<Long?> = product.properties.asSequence()
            .map { properties -> properties.id }
            .toList()
        return productPropertiesService.findAllByIds(propertiesIds)
    }

    private fun findCategoryById(product: Product): Category {
        return categoryService.findById(product.category?.id!!)
    }

    private fun validateShopStatus(shop: Shop) {
        val shopStatus = shopProfileService.findStatusByShopId(shop.id!!)
        if (shopStatus == ShopStatus.AWAITING_CONFIRMATION)
            throw OnlineShopException("shop with id = $shop.id not allowed!")
    }

    private fun findShopById(product: Product): Shop {
        val shop = shopService.findById(product.shop?.id!!)
        validateShopStatus(shop)
        return shop
    }

}