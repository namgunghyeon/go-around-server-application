package com.anyone.go_around_api.feed.adapter.`in`.web

import com.anyone.go_around_api.common.Mapper
import com.anyone.go_around_api.feed.adapter.`in`.web.request.NewFeedDto
import com.anyone.go_around_api.feed.application.port.out.vo.NewFeedVo
import com.anyone.type.account.GoAroundAccount

@Mapper
class FeedDtoMapper {
    fun toNewFeedVo(goAroundAccount: GoAroundAccount, newFeedDto: NewFeedDto): NewFeedVo {
        return NewFeedVo(goAroundAccount, newFeedDto.content)
    }
}