package com.anyone.type.account

import org.springframework.security.core.annotation.AuthenticationPrincipal

@Retention(AnnotationRetention.RUNTIME)
@Target(
    AnnotationTarget.VALUE_PARAMETER
)
@AuthenticationPrincipal(expression = "#this == 'anonymousUser' ? null : goAroundAccount")
annotation class CurrentAccount
