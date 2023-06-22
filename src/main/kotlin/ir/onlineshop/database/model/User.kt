package ir.onlineshop.database.model

import ir.onlineshop.database.model.enums.UserRole
import jakarta.persistence.*
import org.hibernate.Hibernate
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import java.time.LocalDateTime
import kotlin.jvm.Transient

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
    private var username: String = "",

    @Column(name = "PASSWORD", nullable = false)
    private var password: String = "",

    @Column(name = "FIRST_NAME")
    var firstname: String? = null,

    @Column(name = "LAST_NAME")
    var lastname: String? = null,

    @Column(name = "PHONE_NUMBER")
    var phoneNumber: String? = null,

    @Column(name = "EMAIL")
    var email: String? = null,

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ROLE")
    var role: Role? = null,

) : UserDetails {

    @Transient
    var authorities: List<Authority> = listOf()

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

    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
        return mutableListOf(SimpleGrantedAuthority(role!!.name))
    }

    override fun getPassword(): String {
        return this.password
    }

    override fun getUsername(): String {
        return this.username
    }

    override fun isAccountNonExpired(): Boolean {
        return true
    }

    override fun isAccountNonLocked(): Boolean {
        return true
    }

    override fun isCredentialsNonExpired(): Boolean {
        return true
    }

    override fun isEnabled(): Boolean {
        return true
    }

    fun setUsername(username: String) {
        this.username = username
    }

    fun setPassword(password: String) {
        this.password = password
    }
}
