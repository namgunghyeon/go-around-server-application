package com.anyone.go_around_api.feed.application.service

import com.anyone.go_around_api.feed.application.port.`in`.FeedUseCase
import com.anyone.mysql_domain.feed.FeedRepository
import org.springframework.stereotype.Service

@Service
class FeedService(
    private val feedRepository: FeedRepository
): FeedUseCase {
    override fun newFeed() {
        TODO("Not yet implemented")
    }

    override fun getFeeds() {

    }

    override fun updateFeed() {
        TODO("Not yet implemented")
    }
}