package com.anyone.go_around_api.feed.application.service.dto

import com.anyone.type.category.CategoryType

data class RequestFeedPramsDto (
    val offset: Long,
    val limit: Long,
    val category: CategoryType
)