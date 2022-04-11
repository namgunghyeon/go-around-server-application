package com.anyone.go_around_api.feed.adapter.out

import com.anyone.go_around_api.feed.application.port.out.vo.NewFeedVo
import com.anyone.go_around_api.feed.application.port.out.NewFeedPort
import com.anyone.mysql_domain.feed.Feed
import com.anyone.mysql_domain.feed.FeedRepository
import org.springframework.stereotype.Service

@Service
class FeedPersistenceAdapter(
    private val feedRepository: FeedRepository,
    private val feedEntityMapper: FeedEntityMapper
): NewFeedPort {
    override fun saveFeed(newFeedVo: NewFeedVo) {
        val feed: Feed = feedEntityMapper.toFeed(newFeedVo)
        feedRepository.save(feed)
    }
}