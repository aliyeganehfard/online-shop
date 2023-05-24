package ir.onlineshop.service.impl

import ir.onlineshop.database.model.Shop
import ir.onlineshop.database.model.ShopProfile
import ir.onlineshop.database.model.enums.ShopStatus
import ir.onlineshop.database.repository.ShopProfileRepository
import ir.onlineshop.service.ShopProfileService
import ir.onlineshop.service.ShopService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Lazy
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDateTime

@Service
class ShopProfileServiceImpl @Autowired constructor(
    private val shopProfileRepository: ShopProfileRepository,
    @Lazy private val shopService: ShopService
) : ShopProfileService {

    @Transactional
    override fun save(shop: Shop, shopStatus: ShopStatus) {
        val shopProfileList = disActiveShopProfile(shop)
        val shopProfile = ShopProfile().apply {
            this.shop = shop
            this.status = shopStatus
            this.active = true
            this.statusStartDate = LocalDateTime.now()
        }
        shopProfileList.add(shopProfile)
        shopProfileRepository.saveAll(shopProfileList)
    }

    override fun findShopsWithAwaitingConfirmationsStatus(): List<ShopProfile> {
        return findActiveShopProfilesByShopStatus(ShopStatus.AWAITING_CONFIRMATION)
    }

    override fun confirmShopRequest(shopId: Long): Boolean {
        val shop = shopService.findById(shopId)
        this.save(shop, ShopStatus.NEW)
        return true
    }

    override fun findAll(): List<ShopProfile> {
        return shopProfileRepository.findAll()
    }

    override fun findStatusByShopId(shopId: Long) : ShopStatus{
       return shopProfileRepository.findStatusByShopId(shopId)
    }

    private fun disActiveShopProfile(shop: Shop): MutableList<ShopProfile> {
        val shopProfileList = getShopProfileByShopIdAndActiveStatus(shop, true)
        if (shopProfileList.isNotEmpty()) {
            shopProfileList.asSequence().forEach { item ->
                if (item.active) {
                    item.statusEndDate = LocalDateTime.now()
                    item.active = false
                }
            }
        }
        return shopProfileList
    }

    private fun getShopProfileByShopIdAndActiveStatus(shop: Shop, active: Boolean) =
        shopProfileRepository.findByShopIdAndActive(shop.id!!, active)

    private fun findActiveShopProfilesByShopStatus(shopStatus: ShopStatus) =
        shopProfileRepository.findByStatusAndActive(shopStatus, true)
}