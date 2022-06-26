package com.anyone.go_around_api.feed.application.service

import com.anyone.go_around_api.feed.application.port.`in`.FeedUseCase
import com.anyone.go_around_api.feed.application.port.out.LoadFeedPort
import com.anyone.go_around_api.feed.application.port.out.vo.CreateFeedVo
import com.anyone.go_around_api.feed.application.port.out.NewFeedPort
import com.anyone.go_around_api.feed.application.port.out.vo.FeedPramsVo
import com.anyone.go_around_api.feed.application.port.out.vo.FeedVo
import com.anyone.go_around_api.feed.application.service.dto.RequestFeedPramsDto
import org.springframework.stereotype.Service

@Service
class FeedService(
    private val newFeedPort: NewFeedPort,
    private val loadFeedPort: LoadFeedPort
): FeedUseCase {
    override fun newFeed(createFeedVo: CreateFeedVo): FeedVo {
        val feed = newFeedPort.saveFeed(createFeedVo)

        return FeedVo(
            feed.id!!,
            feed.title,
            feed.content
        )
    }

    override fun getFeeds(requestFeedPramsDto: RequestFeedPramsDto): List<FeedVo> {
        loadFeedPort.findAll(FeedPramsVo());
        return listOf()
    }

    override fun updateFeed() {
        TODO("Not yet implemented")
    }
}