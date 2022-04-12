package com.anyone.go_around_api.feed.application.port.out.vo

import com.anyone.type.account.GoAroundAccount

data class CreateFeedVo(
    val goAroundAccount: GoAroundAccount,
    val title: String,
    val content: String
)