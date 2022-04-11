package com.anyone.go_around_api.feed.application.port.out.vo

import com.anyone.type.account.GoAroundAccount

data class NewFeedVo(
    val goAroundAccount: GoAroundAccount,
    val content: String
)