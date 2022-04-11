package com.anyone.go_around_api.feed.application.port.out

import com.anyone.go_around_api.feed.application.port.out.vo.NewFeedVo


interface NewFeedPort {
    fun saveFeed(newFeedVo: NewFeedVo)
}