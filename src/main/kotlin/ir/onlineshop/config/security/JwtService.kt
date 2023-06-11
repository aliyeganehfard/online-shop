package ir.onlineshop.config.security

import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import io.jsonwebtoken.io.Decoders
import io.jsonwebtoken.security.Keys
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Service
import java.security.Key
import java.security.SecureRandom
import java.util.*
import java.util.function.Function
import javax.crypto.KeyGenerator


@Service
class JwtService {

    companion object {
        const val SECRET_KEY = "IUAtfsrQw582dMR1JRX86q8dgkAu5jqTFzowW+Ydnn0="
    }

    fun extractUsername(token: String): String {
        return extractClaim(token, Claims::getSubject)
    }

    fun <T> extractClaim(token: String, claimsResolver: Function<Claims, T>): T {
        val claims = extractAllClaims(token)
        return claimsResolver.apply(claims)
    }

    fun generateToken(extraClaim: Map<String, Any>, userDetails: UserDetails): String {
        return Jwts
            .builder()
            .setClaims(extraClaim)
            .setSubject(userDetails.username)
            .setIssuedAt(Date(System.currentTimeMillis()))
            .setExpiration(Date(System.currentTimeMillis() + 1000 * 24 * 60))
            .signWith(getSignInKey(), SignatureAlgorithm.ES256)
            .compact()
    }

    fun generateToken(userDetails: UserDetails): String {
        return generateToken(mapOf(), userDetails)
    }

    fun isTokenValid(token: String, userDetails: UserDetails): Boolean {
        val username = extractUsername(token)
        return username == userDetails.username && !isTokenExpired(token)
    }

    private fun isTokenExpired(token: String): Boolean {
        return extractExpiration(token).before(Date())
    }

    private fun extractExpiration(token: String): Date {
        return extractClaim(token, Claims::getExpiration)
    }

    private fun extractAllClaims(token: String): Claims {
        return Jwts
            .parserBuilder()
            .setSigningKey(getSignInKey())
            .build()
            .parseClaimsJws(token)
            .body
    }

    private fun getSignInKey(): Key {
        val keyBytes = Decoders.BASE64.decode(SECRET_KEY)
//        val keyBytes = Base64.getDecoder().decode(generateSecretKey())
        return Keys.hmacShaKeyFor(keyBytes)
    }

    private fun generateSecretKey(): String {
        val keyGenerator = KeyGenerator.getInstance("ECB")
        val secureRandom = SecureRandom()
        keyGenerator.init(256, secureRandom)
        val secretKey = keyGenerator.generateKey()
        val keyBytes = secretKey.encoded
        return Base64.getEncoder().encodeToString(keyBytes)
    }
}
