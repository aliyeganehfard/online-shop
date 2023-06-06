package ir.onlineshop.config.security

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder

@Configuration
class PasswordEncryption {

    companion object{
        @Bean
        fun getBCryptPasswordEncoder():PasswordEncoder{
            return BCryptPasswordEncoder()
        }
    }
}