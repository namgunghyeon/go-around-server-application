package com.anyone.go_around_api.feed.application.port.out

import com.anyone.go_around_api.feed.application.port.out.vo.CreateFeedVo
import com.anyone.mysql_domain.feed.Feed


interface NewFeedPort {
    fun saveFeed(createFeedVo: CreateFeedVo): Feed
}