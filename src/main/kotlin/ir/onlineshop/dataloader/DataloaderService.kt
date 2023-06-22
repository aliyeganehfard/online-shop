package ir.onlineshop.dataloader

import ir.onlineshop.common.exception.OnlineShopException
import ir.onlineshop.database.model.Authority
import ir.onlineshop.database.model.Role
import ir.onlineshop.database.model.User
import ir.onlineshop.database.repository.AuthorityRepository
import ir.onlineshop.database.repository.RoleRepository
import ir.onlineshop.database.repository.UserRepository
import ir.onlineshop.service.UserService
import jakarta.annotation.PostConstruct
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class DataloaderService @Autowired constructor(
    val userService: UserService,
    val roleService: RoleRepository,
    val authorityService: AuthorityRepository
) {

    @Transactional
    @PostConstruct
    fun init() {
        val authorities = mutableListOf(
            Authority(permission = "CREATE"),
            Authority(permission = "READ"),
            Authority(permission = "UPDATE"),
            Authority(permission = "DELETE"),
        )
        authorityService.saveAll(authorities)

        val roles = listOf(
            Role(name = "ADMIN"),
            Role(name = "SELLER"),
            Role(name = "CUSTOMER")
        )
        roles[0].authorities = authorities.toSet()
        roles[2].authorities = setOf(authorities[1])
        roleService.saveAll(roles)
//        roles[0].authorities = authorityService.findAll()
//        roleService.save(roles[0])

//
        val users = listOf(
            User(username = "admin", password = "admin", role = roles[0]),
            User(username = "seller", password = "seller"),
            User(username = "customer", password = "customer")
        )

        val admin = User(username = "admin", password = "admin", role = roles[0])
        userService.signUp(admin)

        val customer = User(username = "seller", password = "seller", role = roles[2])
        userService.signUp(customer)
//        val roleAdmin = roleService.findById(roles[0].id!!).orElseThrow {
//            OnlineShopException("role not found")
//        }
//
//        users[0].role = roleAdmin
//        userService.saveAll(users)

//        var authority = Authority(permission = "READ")
//        authority = authorityService.save(authority)
//
//        var role = Role().apply {
//            this.name = "ADMIN"
//        }
//        role.authorities?.add(authority)
//        role = roleService.save(role)
//
//        val user = User().apply {
//            this.username = "admin"
//            this.password = "admin"
//            this.role = role
//        }
//        userService.save(user)


//        val authority1 = Authority(permission = "AUTHORITY_1")
//        val authority2 = Authority(permission = "AUTHORITY_2")
//        val authority3 = Authority(permission = "AUTHORITY_3")
//
//        authorityService.saveAll(listOf(authority1, authority2, authority3))
//
//        val role = Role(
//            name = "ROLE_1",
//            authorities = setOf(authority1, authority2)
//        )
//
//        roleService.save(role)
    }
}