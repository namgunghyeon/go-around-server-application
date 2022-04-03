package com.anyone.go_around_api.account.adapter.`in`.web.request

import javax.validation.constraints.NotBlank

data class SignUpDto(
    @NotBlank
    val email: String,
    @NotBlank
    val name: String,
    @NotBlank
    val password: String,
)