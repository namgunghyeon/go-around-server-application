package com.anyone.go_around_jwt

import com.anyone.go_around_jwt.token.JwtTokenProvider
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class JwtTokenProviderTests @Autowired constructor(
    private val jwtTokenProvider: JwtTokenProvider
) {
    @Test
    fun `토큰_테스트`() {
        val token: String = jwtTokenProvider.generateToken("name")
        jwtTokenProvider.parseToken(token)
        jwtTokenProvider.validate(token)

        Assertions.assertNotNull(token)
    }
}