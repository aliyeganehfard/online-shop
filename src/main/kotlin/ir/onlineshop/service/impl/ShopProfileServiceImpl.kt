package ir.onlineshop.service.impl

import ir.onlineshop.database.model.Shop
import ir.onlineshop.database.model.ShopProfile
import ir.onlineshop.database.model.enums.ShopStatus
import ir.onlineshop.database.repository.ShopProfileRepository
import ir.onlineshop.service.ShopProfileService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDateTime

@Service
class ShopProfileServiceImpl @Autowired constructor(
    private val shopProfileRepository: ShopProfileRepository
) : ShopProfileService {

    @Transactional
    override fun save(shop: Shop, shopStatus: ShopStatus) {
        val shopProfile = ShopProfile()
        val shopProfileList = disActiveShopProfile(shop)

        shopProfile.shop = shop
        shopProfile.status = shopStatus
        shopProfile.active= true
        shopProfile.statusStartDate = LocalDateTime.now()
        shopProfileList.add(shopProfile)

        shopProfileRepository.saveAll(shopProfileList)
    }

    override fun findShopsWithAwaitingConfirmationsStatus(): List<ShopProfile> {
       return findShopsByStatus(ShopStatus.AWAITING_CONFIRMATION)
    }

    override fun findByShopId(shopId: Long) {
        TODO("Not yet implemented")
    }

    private fun disActiveShopProfile(shop :Shop): MutableList<ShopProfile> {
        val shopProfileList = getShopProfileByShopIdAndActiveStatus(shop,true)
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

    private fun findShopsByStatus(shopStatus: ShopStatus) =
        shopProfileRepository.findByStatus(shopStatus)
}