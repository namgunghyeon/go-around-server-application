package com.anyone.go_around_jwt.token

import org.springframework.stereotype.Component

@Component
class JwtTokenHelper {
    fun generateToken(): String {
        return "jwt token";
    }
}