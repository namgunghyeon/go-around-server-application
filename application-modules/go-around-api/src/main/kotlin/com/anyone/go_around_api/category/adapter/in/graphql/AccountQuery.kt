package com.anyone.go_around_api.category.adapter.`in`.graphql

import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.RestController

@RestController
class AccountQuery {
    @QueryMapping
    @PreAuthorize("isAuthenticated()")
    fun me(): String {
        return "1"
    }
}