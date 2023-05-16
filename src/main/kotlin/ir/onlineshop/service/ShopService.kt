package ir.onlineshop.service

import ir.onlineshop.domein.model.Shop
import ir.onlineshop.domein.repository.ShopRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ShopService @Autowired constructor(
    private val shopRepository: ShopRepository
) {

    fun save(shop: Shop): Shop {
        return shopRepository.save(shop)
    }

    fun findAll(): List<Shop> {
        return shopRepository.findAll()
    }
}