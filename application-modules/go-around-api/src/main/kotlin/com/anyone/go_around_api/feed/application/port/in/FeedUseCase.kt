package com.anyone.go_around_api.feed.application.port.`in`

import com.anyone.go_around_api.feed.application.port.out.vo.FeedVo
import com.anyone.go_around_api.feed.application.port.out.vo.CreateFeedVo
import com.anyone.go_around_api.feed.application.service.dto.RequestFeedPramsDto

interface FeedUseCase {
    fun newFeed(createFeedVo: CreateFeedVo): FeedVo
    fun getFeeds(requestFeedPramsDto: RequestFeedPramsDto): List<FeedVo>
    fun updateFeed()
}