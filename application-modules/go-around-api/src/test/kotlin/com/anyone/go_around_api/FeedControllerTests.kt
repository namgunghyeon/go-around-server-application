package com.anyone.go_around_api

import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get

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
        }.andReturn()
    }
}