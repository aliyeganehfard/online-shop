package ir.onlineshop.config.security

import ir.onlineshop.common.exception.OnlineShopException
import ir.onlineshop.database.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.AuthenticationProvider
import org.springframework.security.authentication.dao.DaoAuthenticationProvider
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration
import org.springframework.security.config.annotation.authentication.configurers.userdetails.DaoAuthenticationConfigurer
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.provisioning.InMemoryUserDetailsManager
import org.springframework.security.provisioning.JdbcUserDetailsManager
import org.springframework.security.provisioning.UserDetailsManager
import org.springframework.security.web.SecurityFilterChain
import javax.sql.DataSource

@Configuration
@EnableWebSecurity
class SecurityConfig @Autowired constructor(
    val userRepository: UserRepository
) {

    @Bean
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
        http.authorizeHttpRequests()
            .requestMatchers("user/save").permitAll()
            .requestMatchers("hello/permitAll").permitAll()
            .requestMatchers("user/findAll").permitAll()
            .anyRequest().authenticated().and()
            .formLogin().and()
            .httpBasic()

        http.csrf().disable()

        return http.build()
    }

//    @Bean
//    fun configure(auth: AuthenticationManagerBuilder) {
//        auth.userDetailsService(userDetailsService())
//            .passwordEncoder(PasswordEncryption.getBCryptPasswordEncoder())
//    }

    @Bean
    fun authenticationProvider(): AuthenticationProvider {
        val authProvider = DaoAuthenticationProvider()
        authProvider.setUserDetailsService(userDetailsService())
        authProvider.setPasswordEncoder(BCryptPasswordEncoder())
        return authProvider
    }

    @Bean
    fun getBCryptPasswordEncoder(): PasswordEncoder {
        return BCryptPasswordEncoder()
    }

    @Bean
    fun authenticationManager(configuration: AuthenticationConfiguration): AuthenticationManager{
        return configuration.authenticationManager
    }

    @Bean
    fun userDetailsService(): UserDetailsService {
        return UserDetailsService { username: String ->
            userRepository.findByUsername(username)
                .orElseThrow { OnlineShopException("username : $username not found!") }
        }
    }

//    @Bean
//    fun users(): UserDetailsService {
//        val encoder = PasswordEncryption.getBCryptPasswordEncoder()
//        val admin = User.builder()
//            .username("admin")
//            .password(encoder.encode("admin"))
//            .roles("USER", "ADMIN")
//            .build()
//
//        val user = User.builder()
//            .username("user")
//            .password(encoder.encode("user"))
//            .roles("USER")
//            .build()
//
//        return InMemoryUserDetailsManager(user, admin)
//    }
}