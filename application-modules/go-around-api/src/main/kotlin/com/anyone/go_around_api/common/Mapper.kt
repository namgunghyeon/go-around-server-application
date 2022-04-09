package com.anyone.go_around_api.common

import org.springframework.core.annotation.AliasFor
import org.springframework.stereotype.Component

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
@Component
annotation class Mapper(
    @get: AliasFor(annotation = Component::class)
    val value: String = ""
)
