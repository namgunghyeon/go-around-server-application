package com.anyone.go_around_jwt

import com.anyone.go_around_jwt.config.JwtTokenProperties
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties

@SpringBootApplication
@EnableConfigurationProperties(JwtTokenProperties::class)
class GoAroundJwtApplication {
}