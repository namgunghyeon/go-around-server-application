package com.anyone.go_around_api.feed.application.port.`in`

import com.anyone.go_around_api.feed.application.port.out.vo.FeedVo
import com.anyone.go_around_api.feed.application.port.out.vo.CreateFeedVo

interface FeedUseCase {
    fun newFeed(createFeedVo: CreateFeedVo): FeedVo
    fun getFeeds(accountId: Long): List<FeedVo>
    fun updateFeed()
}