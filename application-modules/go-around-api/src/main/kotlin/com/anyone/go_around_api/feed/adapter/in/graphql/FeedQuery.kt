package com.anyone.go_around_api.feed.adapter.`in`.graphql

import com.anyone.go_around_api.feed.adapter.`in`.FeedDtoMapper
import com.anyone.go_around_api.feed.application.port.`in`.FeedUseCase
import com.anyone.go_around_api.feed.application.port.out.vo.FeedVo
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.RestController

@RestController
class FeedQuery(
    private val feedUseCase: FeedUseCase,
    private val feedDtoMapper: FeedDtoMapper
) {
}