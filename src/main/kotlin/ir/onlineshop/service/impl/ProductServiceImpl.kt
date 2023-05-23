package ir.onlineshop.service.impl

import ir.onlineshop.database.model.Product
import ir.onlineshop.database.repository.ProductRepository
import ir.onlineshop.service.ProductService
import ir.onlineshop.service.ShopService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ProductServiceImpl @Autowired constructor(
    private val productRepository: ProductRepository,
    private val shopService: ShopService
) : ProductService {

    @Transactional
    override fun save(product: Product) {
        val shop = shopService.findById(product.shop?.id!!)
        product.shop = shop
        productRepository.save(product)
    }
}