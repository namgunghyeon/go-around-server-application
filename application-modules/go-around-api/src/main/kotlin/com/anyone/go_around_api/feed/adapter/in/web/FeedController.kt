package com.anyone.go_around_api.feed.adapter.`in`.web

import com.anyone.go_around_api.common.GoAroundV1APIController
import com.anyone.go_around_api.feed.adapter.`in`.web.request.CreateFeedDto
import com.anyone.go_around_api.feed.adapter.`in`.web.response.FeedDto
import com.anyone.go_around_api.feed.application.port.`in`.FeedUseCase
import com.anyone.go_around_api.feed.application.port.out.vo.FeedVo
import com.anyone.go_around_api.feed.application.service.dto.RequestFeedPramsDto
import com.anyone.type.account.CurrentAccount
import com.anyone.type.account.GoAroundAccount
import com.anyone.type.category.CategoryType
import com.anyone.type.web.response.Response
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@GoAroundV1APIController
@RestController
class FeedController(
    private val feedUseCase: FeedUseCase,
    private val feedDtoMapper: FeedDtoMapper
) {
    @GetMapping("/feeds")
    fun feeds(@CurrentAccount goAroundAccount: GoAroundAccount): Response<List<FeedVo>> {
        feedUseCase.getFeeds(RequestFeedPramsDto(1L, 1L, CategoryType.CROSS_FIT))

        return Response(listOf())
    }

    @PostMapping("/feeds")
    fun newFeed(
        @CurrentAccount goAroundAccount: GoAroundAccount,
        @RequestBody newFeedDto: CreateFeedDto
    ): Response<FeedDto> {
        val feedVo = feedUseCase.newFeed(feedDtoMapper.toCreateFeedVo(goAroundAccount, newFeedDto))

        return Response(feedDtoMapper.toFeedDto(feedVo))
    }
}