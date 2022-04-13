package com.anyone.go_around_jwt.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConstructorBinding
@ConfigurationProperties(prefix = "jwt")
class JwtTokenProperties(
    var secret: String,
    var accessTokenDuration: Long,
    var refreshTokenDuration: Long,
    val issuer: String
)