package com.anyone.go_around_api.feed.adapter.out

import com.anyone.go_around_api.common.Mapper
import com.anyone.go_around_api.feed.application.port.out.vo.CreateFeedVo
import com.anyone.mysql_domain.feed.Feed

@Mapper
class FeedEntityMapper {
    fun toFeed(createFeedVo: CreateFeedVo): Feed {
        return Feed(
            createFeedVo.goAroundAccount.accountId,
            1L,
            createFeedVo.title,
            createFeedVo.content
        )
    }
}