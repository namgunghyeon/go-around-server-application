package com.anyone.go_around_api

import com.anyone.go_around_api.account.adapter.`in`.web.request.SignInDto
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get
import org.springframework.test.web.servlet.post

@AutoConfigureMockMvc
@SpringBootTest
class CategoryControllerTests @Autowired constructor(
    override val mockMvc: MockMvc,
    override val objectMapper: ObjectMapper
): TestUserAccount(mockMvc, objectMapper) {

    @Test
    fun `카테고리 가져오기` () {
        println(this.tokenDto)
        mockMvc.get("/api/v1/categories") {
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