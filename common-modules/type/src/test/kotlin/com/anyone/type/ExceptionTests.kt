package com.anyone.type

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import com.anyone.type.web.exception.InvalidTokenException

@SpringBootTest
class ExceptionTests {

    @Test
    fun `에러 테스트`() {
       val invalidTokenException: InvalidTokenException = InvalidTokenException("invalid token")
        Assertions.assertEquals("invalid token", invalidTokenException.message)
    }
}