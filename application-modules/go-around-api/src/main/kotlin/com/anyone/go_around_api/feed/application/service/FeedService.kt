package com.anyone.go_around_api.feed.application.service

import com.anyone.go_around_api.feed.adapter.out.FeedEntityMapper
import com.anyone.go_around_api.feed.application.port.`in`.FeedUseCase
import com.anyone.go_around_api.feed.application.port.out.vo.NewFeedVo
import com.anyone.go_around_api.feed.application.port.out.NewFeedPort
import com.anyone.mysql_domain.feed.FeedRepository
import org.springframework.stereotype.Service

@Service
class FeedService(
    private val newFeedPort: NewFeedPort
): FeedUseCase {
    override fun newFeed(newFeedVo: NewFeedVo) {
        newFeedPort.saveFeed(newFeedVo)
    }

    override fun getFeeds() {

    }

    override fun updateFeed() {
        TODO("Not yet implemented")
    }
}