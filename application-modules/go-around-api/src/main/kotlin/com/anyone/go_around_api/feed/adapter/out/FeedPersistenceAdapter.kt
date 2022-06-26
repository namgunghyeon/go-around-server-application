package com.anyone.go_around_api.feed.adapter.out

import com.anyone.go_around_api.feed.application.port.out.LoadFeedPort
import com.anyone.go_around_api.feed.application.port.out.vo.CreateFeedVo
import com.anyone.go_around_api.feed.application.port.out.NewFeedPort
import com.anyone.go_around_api.feed.application.port.out.vo.FeedPramsVo
import com.anyone.mysql_domain.feed.Feed
import com.anyone.mysql_domain.feed.FeedRepository
import org.springframework.stereotype.Service

@Service
class FeedPersistenceAdapter(
    private val feedRepository: FeedRepository,
    private val feedEntityMapper: FeedEntityMapper
): NewFeedPort, LoadFeedPort {
    override fun saveFeed(createFeedVo: CreateFeedVo): Feed {
        val feed: Feed = feedEntityMapper.toFeed(createFeedVo)
        return feedRepository.save(feed)
    }

    override fun findAll(feedPramsVo: FeedPramsVo): List<Feed> {
        return feedRepository.findAll()
    }
}