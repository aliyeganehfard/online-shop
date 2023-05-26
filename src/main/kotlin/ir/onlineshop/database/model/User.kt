package ir.onlineshop.database.model

import ir.onlineshop.database.model.enums.UserRole
import jakarta.persistence.*
import org.hibernate.Hibernate
import java.time.LocalDateTime

@Entity
@Table(name = "USERS")
class User(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(name = "CREATE_DATE")
    var createDate: LocalDateTime? = null,

    @Column(name = "UPDATE_DATE")
    var updateDate: LocalDateTime? = null,

    @Column(name = "USER_NAME", nullable = false)
    var username: String? = null,

    @Column(name = "PASSWORD", nullable = false)
    var password: String? = null,

    @Column(name = "FIRST_NAME")
    var firstname: String? = null,

    @Column(name = "LAST_NAME")
    var lastname: String? = null,

    @Column(name = "PHONE_NUMBER")
    var phoneNumber: String? = null,

    @Column(name = "EMAIL")
    var email: String? = null,

    @Enumerated(EnumType.STRING)
    @Column(name = "ROLE", nullable = false)
    var role: UserRole? = null,
) {
    @PrePersist
    fun setCreateDate() {
        val now = LocalDateTime.now()
        this.createDate = now
        this.updateDate = now
    }

    @PreUpdate
    fun setUpdateDate() {
        this.updateDate = LocalDateTime.now()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as User

        return id != null && id == other.id
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(id = $id , createDate = $createDate , updateDate = $updateDate , username = $username , password = $password , firstname = $firstname , lastname = $lastname , phoneNumber = $phoneNumber , email = $email , role = $role )"
    }


}
