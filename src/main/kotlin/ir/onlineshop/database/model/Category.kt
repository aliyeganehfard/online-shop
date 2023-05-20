package ir.onlineshop.database.model

import jakarta.persistence.*

@Entity
@Table(name = "CATEGORY")
data class Category(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    val id: Long? = null,

    @Column(name = "TITLE", nullable = false)
    var title: String = "",

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PARENT_CATEGORY_ID")
    var parentCategory: Category? = null,

    @OneToMany(mappedBy = "parentCategory", cascade = [CascadeType.ALL], orphanRemoval = true)
    var childCategories: MutableList<Category> = mutableListOf()
)
