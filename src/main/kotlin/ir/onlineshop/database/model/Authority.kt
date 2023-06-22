package ir.onlineshop.database.model

import jakarta.persistence.*

@Entity
@Table(name = "AUTHORITY")
data class Authority(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    var id: Long? = null,

    @Column(name= "PERMISSION", nullable = false)
    var permission: String? = null,

    @ManyToMany(mappedBy = "authorities")
    var roles: Set<Role> = emptySet()


)
