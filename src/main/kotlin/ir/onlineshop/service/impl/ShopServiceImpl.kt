package ir.onlineshop.service.impl

import ir.onlineshop.database.model.Shop
import ir.onlineshop.database.model.enums.ShopStatus
import ir.onlineshop.database.repository.ShopRepository
import ir.onlineshop.service.ShopProfileService
import ir.onlineshop.service.ShopService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ShopServiceImpl @Autowired constructor(
    private val shopRepository: ShopRepository,
    private val shopProfileService: ShopProfileService
) : ShopService {

    private val log: Logger = LoggerFactory.getLogger(ShopServiceImpl::class.java.name)

    @Transactional
    override fun save(shop: Shop): Shop {
        val savedShop = shopRepository.save(shop)
        saveShopStatus(savedShop)
        return savedShop
    }

    private fun saveShopStatus(shop: Shop) {
        shopProfileService.save(shop,ShopStatus.AWAITING_CONFIRMATION)
    }

    override fun findAll(): List<Shop> {
        return shopRepository.findAll()
    }

    override fun findById(id: Long): Shop {
        return shopRepository.findById(id).orElseThrow { (Exception(id.toString())) }
    }
}