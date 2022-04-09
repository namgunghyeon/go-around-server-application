package com.anyone.go_around_jwt.token

import com.anyone.go_around_jwt.config.JwtTokenProperties
import com.anyone.type.account.GoAroundAccount
import com.anyone.type.web.exception.InvalidTokenException
import io.jsonwebtoken.Claims
import io.jsonwebtoken.JwtException
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import io.jsonwebtoken.security.Keys
import org.springframework.stereotype.Component
import java.security.Key
import java.util.Date
import javax.annotation.PostConstruct

@Component
class JwtTokenProvider(
    private val jwtTokenProperties: JwtTokenProperties
) {
    private var key: Key? = null;

    @PostConstruct
    fun init() {
        key = Keys.hmacShaKeyFor(jwtTokenProperties.secret.toByteArray(Charsets.UTF_8))
    }

    fun generateToken(name: String): String {
        val claims: Claims = Jwts.claims().setSubject(name)
        claims["email"] = name
        claims["token"] = "accessToken"

       return this.buildToken(claims);
    }

    fun generateRefreshToken(token: String): String {
        val claims = this.getClaimsFromToken(token)
        claims["token"] = "refreshToken"

        return this.buildToken(claims);
    }

    fun getEmailFromToken(token: String): String {
        val claims: Claims = this.getClaimsFromToken(token)

        return claims["email"] as String
    }

    private fun getClaimsFromToken(token: String): Claims {
        try {
            return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .body
        } catch (ex: Exception) {
            throw InvalidTokenException("토큰 정보가 유효하지 않습니다.")
        }
    }

    fun parseToken(token: String): GoAroundAccount {
        val claims = Jwts.parserBuilder()
            .setSigningKey(key)
            .build()
            .parseClaimsJws(token)


        return GoAroundAccount(
            "name",
            "password",
            "email"
        );
    }



    private fun buildToken(claims: Claims): String {
        val now = Date()
        return Jwts.builder()
            .setHeaderParam("type", "JWT")
            .setClaims(claims)
            .setIssuedAt(now)
            .setIssuer(jwtTokenProperties.issuer)
            .setExpiration(Date(now.time + jwtTokenProperties.duration))
            .signWith(this.key, SignatureAlgorithm.HS256)
            .compact()
    }

    fun validate(token: String): Boolean {
        try {
            Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
            return true
        } catch (e: JwtException) {
            return false;
        } catch (e: java.lang.IllegalArgumentException) {
            return false;
        }
    }
}