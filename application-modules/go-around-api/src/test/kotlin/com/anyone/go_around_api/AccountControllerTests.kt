package com.anyone.go_around_api

import com.anyone.go_around_api.account.adapter.`in`.web.request.SignInDto
import com.anyone.go_around_api.account.adapter.`in`.web.request.SignUpDto
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.post

@AutoConfigureMockMvc
@SpringBootTest
class AccountControllerTests @Autowired constructor(
    private val mockMvc: MockMvc,
    private val objectMapper: ObjectMapper
) {
    @Test
    fun `회원가입` () {
        mockMvc.post("/api/v1/accounts/sign-up") {
            contentType = MediaType.APPLICATION_JSON
            content = objectMapper.writeValueAsString(SignUpDto("222test@gmail.com","name","xptmxm#1"))
        }.andDo { print() }.andExpect { status { isOk() } }
    }

    @Test
    fun `로그인 성공` () {
        mockMvc.post("/api/v1/accounts/sign-in") {
            contentType = MediaType.APPLICATION_JSON
            content = objectMapper.writeValueAsString(SignInDto("test@gmail.com","xptmxm#1"))
        }.andDo { print() }.andExpect { status { isOk() } }
    }

    @Test
    fun `로그인 실패` () {
        mockMvc.post("/api/v1/accounts/sign-in"){
            contentType = MediaType.APPLICATION_JSON
            content = objectMapper.writeValueAsString(SignInDto("tes1t@gmail.com","xptmxm#1"))
        }.andDo { print() }.andExpect { status { isUnauthorized() } }
    }
}