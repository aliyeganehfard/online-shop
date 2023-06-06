package ir.onlineshop.config.security

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.provisioning.InMemoryUserDetailsManager
import org.springframework.security.web.SecurityFilterChain

@Configuration
@EnableWebSecurity
class SecurityConfig {

    @Bean
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain{
        http.authorizeHttpRequests()
            .requestMatchers("hello/permitAll").permitAll()
            .anyRequest().authenticated().and()
            .formLogin().and()
            .httpBasic()
        return http.build()
    }

    @Bean
    fun users(): UserDetailsService {
        val encoder = PasswordEncryption.getBCryptPasswordEncoder()
        val admin = User.builder()
            .username("admin")
            .password(encoder.encode("admin"))
            .roles("USER", "ADMIN")
            .build()

        val user = User.builder()
            .username("user")
            .password(encoder.encode("user"))
            .roles("USER")
            .build()

        return InMemoryUserDetailsManager(user, admin)
    }
}