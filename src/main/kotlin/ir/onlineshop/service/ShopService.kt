package ir.onlineshop.service

import ir.onlineshop.database.model.Shop
import ir.onlineshop.database.repository.ShopRepository
import org.slf4j.Logger
import org.slf4j.LoggerFactory
//import lombok.extern.slf4j.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import kotlin.math.log

@Service
class ShopService @Autowired constructor(
    private val shopRepository: ShopRepository
) {
    private val log:Logger = LoggerFactory.getLogger(ShopService::class.java.name)

    fun save(shop: Shop): Shop {
        return shopRepository.save(shop)
    }

    fun findAll(): List<Shop> {
        return shopRepository.findAll()
    }
}