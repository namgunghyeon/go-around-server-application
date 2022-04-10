package com.anyone.go_around_api.feed.adapter.`in`.web

import com.anyone.go_around_api.common.GoAroundV1APIController
import com.anyone.go_around_api.feed.application.port.`in`.FeedUseCase
import com.anyone.type.account.CurrentAccount
import com.anyone.type.account.GoAroundAccount
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@GoAroundV1APIController
@RestController
class FeedController(
    private val feedUseCase: FeedUseCase
) {
    @GetMapping("/feeds")
    fun feeds(@CurrentAccount goAroundAccount: GoAroundAccount): String {
        feedUseCase.getFeeds()
        return "feeds";
    }
}