package com.anyone.go_around_api.account.application.service.vo

data class TokenVo(
    val accessToken: String = "",
    val refreshToken: String = ""
)