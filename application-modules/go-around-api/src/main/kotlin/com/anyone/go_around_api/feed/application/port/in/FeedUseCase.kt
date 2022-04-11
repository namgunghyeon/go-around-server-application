package com.anyone.go_around_api.feed.application.port.`in`

import com.anyone.go_around_api.feed.application.port.out.vo.NewFeedVo

interface FeedUseCase {
    fun newFeed(newFeedVo: NewFeedVo)
    fun getFeeds()
    fun updateFeed()
}