package com.anyone.go_around_api.account.adapter.`in`.web.request

import javax.validation.constraints.NotBlank

data class SignInDto(
    @NotBlank
    val email: String,
    @NotBlank
    val password: String
)