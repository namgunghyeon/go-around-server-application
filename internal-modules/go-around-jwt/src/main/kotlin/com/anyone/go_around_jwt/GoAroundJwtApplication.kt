package com.anyone.go_around_jwt

import com.anyone.go_around_jwt.config.JwtTokenProperties
import com.anyone.type.TypeApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties

@SpringBootApplication(scanBasePackageClasses = [
    GoAroundJwtApplication::class,
    TypeApplication::class
])
@EnableConfigurationProperties(JwtTokenProperties::class)
class GoAroundJwtApplication {
}