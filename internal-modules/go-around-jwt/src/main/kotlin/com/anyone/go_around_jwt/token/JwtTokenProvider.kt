package com.anyone.go_around_jwt.token

import com.anyone.go_around_jwt.config.JwtTokenProperties
import io.jsonwebtoken.Claims
import io.jsonwebtoken.JwtException
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import io.jsonwebtoken.security.Keys
import org.springframework.stereotype.Component
import java.security.Key
import java.util.Date
import javax.annotation.PostConstruct
import javax.crypto.SecretKey

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
        val clams: Claims = Jwts.claims().setSubject(name)
        clams["email"] = name

        val now = Date()
        return Jwts.builder()
            .setHeaderParam("type", "JWT")
            .setClaims(clams)
            .setIssuedAt(now)
            .setIssuer(jwtTokenProperties.issuer)
            .setExpiration(Date(now.time + jwtTokenProperties.duration))
            .signWith(this.key, SignatureAlgorithm.HS256)
            .compact()
    }

    fun parseToken(token: String) {
        val claims = Jwts.parserBuilder()
            .setSigningKey(key)
            .build()
            .parseClaimsJws(token)

        //TODO
        //유저 객체러 반화
    }

    fun validate(token: String): Boolean {
        try {
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token)
        } catch (e: JwtException) {
            //TODO 에러 재정의
            throw e
        } catch (e: java.lang.IllegalArgumentException) {
            //TODO 에러 재정의
            throw e
        }

        return false;
    }
}