package com.anyone.go_around_api

import com.anyone.go_around_api.feed.adapter.`in`.web.request.CreateFeedDto
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get
import org.springframework.test.web.servlet.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
@AutoConfigureMockMvc
@SpringBootTest
class FeedControllerTests@Autowired constructor(
    override val mockMvc: MockMvc,
    override val objectMapper: ObjectMapper
): TestUserAccount(mockMvc, objectMapper) {

    @Test
    fun `피드 조회`() {
        mockMvc.get("/api/v1/feeds") {
            contentType = MediaType.APPLICATION_JSON
            header("Authorization", "Bearer " + tokenDto?.token)
        }.andDo {
            print()
        }.andExpect {
            status {
                isOk()
            }
        }.andExpect {
            jsonPath("$.version").value("1")
        }.andReturn()
    }

    @Test
    fun `피드 등록`() {
        val stringFeed = objectMapper.writeValueAsString(CreateFeedDto("title", "content"))
        mockMvc.perform(
            post("/api/v1/feeds")
                .contentType(MediaType.APPLICATION_JSON)
                .header("Authorization", "Bearer " + tokenDto?.token)
                .content(stringFeed)
        ).andExpect(jsonPath("$.data.id").exists())
            .andExpect(jsonPath("$.data.title").exists())
            .andExpect(jsonPath("$.data.content").exists());
    }
}