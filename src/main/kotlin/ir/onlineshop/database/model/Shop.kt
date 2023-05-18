package ir.onlineshop.database.model

import jakarta.persistence.*

@Entity
@Table(name = "SHOP")
data class Shop(

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    var id: Long?,

    @Column(name = "NAME", nullable = false)
    var name: String,

    @Column(name = "LATIN_NAME", nullable = false)
    var latinName: String,

    @Column(name = "ABOUT")
    var about: String?,

    @Column(name = "ADDRESS")
    var address: String?

)
{
    constructor() : this(null,"","",null,null)
}
