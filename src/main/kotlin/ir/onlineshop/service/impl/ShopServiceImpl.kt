package ir.onlineshop.service.impl

import ir.onlineshop.database.model.Shop
import ir.onlineshop.database.repository.ShopRepository
import ir.onlineshop.service.ShopService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ShopServiceImpl @Autowired constructor(
    private val shopRepository: ShopRepository
) : ShopService {
    private val log: Logger = LoggerFactory.getLogger(ShopServiceImpl::class.java.name)

    override fun save(shop: Shop): Shop {
        return shopRepository.save(shop)
    }

    override fun findAll(): List<Shop> {
        return shopRepository.findAll()
    }

    override fun findById(id: Long): Shop {
        return shopRepository.findById(id).orElseThrow { (Exception(id.toString())) }
    }
}