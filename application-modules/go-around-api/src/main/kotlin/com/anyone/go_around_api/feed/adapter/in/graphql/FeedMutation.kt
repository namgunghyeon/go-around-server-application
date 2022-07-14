package com.anyone.go_around_api.feed.adapter.`in`.graphql

import com.anyone.go_around_api.feed.adapter.`in`.FeedDtoMapper
import com.anyone.go_around_api.feed.adapter.`in`.web.request.CreateFeedDto
import com.anyone.go_around_api.feed.adapter.`in`.web.response.FeedDto
import com.anyone.go_around_api.feed.application.port.`in`.FeedUseCase
import com.anyone.type.account.CurrentAccount
import com.anyone.type.account.GoAroundAccount
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.MutationMapping
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class FeedMutation(
    private val feedUseCase: FeedUseCase,
    private val feedDtoMapper: FeedDtoMapper
) {
    @MutationMapping
    @PreAuthorize("isAuthenticated()")
    fun newFeed(
        @CurrentAccount goAroundAccount: GoAroundAccount,
        @Argument("feed") newFeedDto: CreateFeedDto
    ): FeedDto {
        val feedVo = feedUseCase.newFeed(feedDtoMapper.toCreateFeedVo(goAroundAccount, newFeedDto))

        return feedDtoMapper.toFeedDto(feedVo);
    }
}