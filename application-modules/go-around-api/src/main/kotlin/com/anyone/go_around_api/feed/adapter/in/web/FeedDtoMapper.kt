package com.anyone.go_around_api.feed.adapter.`in`.web

import com.anyone.go_around_api.common.Mapper
import com.anyone.go_around_api.feed.adapter.`in`.web.request.CreateFeedDto
import com.anyone.go_around_api.feed.adapter.`in`.web.response.FeedDto
import com.anyone.go_around_api.feed.application.port.out.vo.CreateFeedVo
import com.anyone.go_around_api.feed.application.port.out.vo.FeedVo
import com.anyone.type.account.GoAroundAccount

@Mapper
class FeedDtoMapper {
    fun toCreateFeedVo(goAroundAccount: GoAroundAccount, newFeedDto: CreateFeedDto): CreateFeedVo {
        return CreateFeedVo(goAroundAccount, newFeedDto.title, newFeedDto.content)
    }

    fun toFeedDto(feedVo: FeedVo): FeedDto {
        return FeedDto(feedVo.id, feedVo.title, feedVo.content)
    }
}