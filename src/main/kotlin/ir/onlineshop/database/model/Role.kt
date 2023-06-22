package ir.onlineshop.database.model

import jakarta.persistence.*

@Entity
@Table(name = "ROLE")
data class Role(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    var id: Long? = null,

    @Column(name = "NAME", nullable = false)
    var name: String? = null,

    @OneToMany(mappedBy = "role", fetch = FetchType.LAZY)
    var user: List<User>? = mutableListOf(),

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "ROLE_AUTHORITY",
        joinColumns = [JoinColumn(name = "ROLE_ID")],
        inverseJoinColumns = [JoinColumn(name = "AUTHORITY_ID")]
    )
    var authorities: Set<Authority>? = emptySet(),

    )
