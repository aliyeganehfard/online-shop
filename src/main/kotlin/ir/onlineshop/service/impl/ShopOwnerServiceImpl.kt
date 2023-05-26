package ir.onlineshop.service.impl

import ir.onlineshop.database.model.ShopOwner
import ir.onlineshop.database.repository.ShopOwnerRepository
import ir.onlineshop.service.ShopOwnerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ShopOwnerServiceImpl @Autowired constructor(
    private val shopOwnerRepository: ShopOwnerRepository
): ShopOwnerService {

    override fun save(shopOwner: ShopOwner) {
        shopOwnerRepository.save(shopOwner)
    }

}