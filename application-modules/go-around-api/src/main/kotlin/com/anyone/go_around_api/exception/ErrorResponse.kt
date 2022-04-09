package com.anyone.go_around_api.exception

data class ErrorResponse(
    val message: String? = null,
    val code: String? = null
)