package com.anyone.go_around_api

import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@AutoConfigureMockMvc
@SpringBootTest
class CategoryControllerTests @Autowired constructor(
    override val mockMvc: MockMvc,
    override val objectMapper: ObjectMapper
): TestUserAccount(mockMvc, objectMapper) {

    @Test
    fun `카테고리 가져오기` () {
        mockMvc.perform(
            get("/api/v1/categories")
                .contentType(MediaType.APPLICATION_JSON)
                .header("Authorization", "Bearer " + tokenDto?.token)

        ).andExpect(jsonPath("$.data").isArray)
            .andExpect(jsonPath("$.data.[0].id").exists())
            .andExpect(jsonPath("$.data.[0].code").exists())
            .andExpect(jsonPath("$.data.[0].displayName").exists());
    }
}