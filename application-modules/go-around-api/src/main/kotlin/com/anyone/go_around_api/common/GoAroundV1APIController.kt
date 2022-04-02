package com.anyone.go_around_api.common

import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.RequestMapping

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
@Component
@RequestMapping("/api/v1")
annotation class GoAroundV1APIController()