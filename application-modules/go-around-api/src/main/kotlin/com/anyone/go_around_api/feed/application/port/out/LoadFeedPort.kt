package com.anyone.go_around_api.feed.application.port.out

import com.anyone.go_around_api.feed.application.port.out.vo.FeedPramsVo
import com.anyone.mysql_domain.account.Account
import com.anyone.mysql_domain.feed.Feed

interface LoadFeedPort {
    fun findAll(feedParamsVo: FeedPramsVo): List<Feed>
}