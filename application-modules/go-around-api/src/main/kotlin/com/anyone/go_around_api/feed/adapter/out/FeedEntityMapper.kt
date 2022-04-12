package com.anyone.go_around_api.feed.adapter.out

import com.anyone.go_around_api.common.Mapper
import com.anyone.go_around_api.feed.application.port.out.vo.NewFeedVo
import com.anyone.mysql_domain.feed.Feed
import com.anyone.type.account.GoAroundAccount

@Mapper
class FeedEntityMapper {
    fun toFeed(newFeedVo: NewFeedVo): Feed {
        return Feed(newFeedVo.goAroundAccount.accountId, newFeedVo.title, newFeedVo.content)
    }
}