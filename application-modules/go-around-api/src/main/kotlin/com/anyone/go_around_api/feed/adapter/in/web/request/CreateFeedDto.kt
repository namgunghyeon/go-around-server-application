package com.anyone.go_around_api.feed.adapter.`in`.web.request

data class CreateFeedDto(
    val title: String,
    val content: String,
    val category: String? = null,
    val survey: List<CreateSurveyDto>? = listOf(),
    val images: List<String>? = listOf()
)