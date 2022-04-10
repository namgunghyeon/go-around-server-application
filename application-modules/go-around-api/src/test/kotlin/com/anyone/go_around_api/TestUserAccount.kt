package com.anyone.go_around_api

import com.anyone.go_around_api.account.adapter.`in`.web.request.SignInDto
import com.anyone.go_around_api.account.adapter.`in`.web.response.TokenDto
import com.anyone.type.web.response.Response
import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.BeforeEach
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.post

open class TestUserAccount constructor(
    open val mockMvc: MockMvc,
    open val objectMapper: ObjectMapper
){
    open var tokenDto: TokenDto? = null

    @BeforeEach
    fun login () {
        if (tokenDto != null) {
            return
        }

        val mvcResult = mockMvc.post("/api/v1/accounts/sign-in") {
            contentType = MediaType.APPLICATION_JSON
            content = objectMapper.writeValueAsString(SignInDto("test@gmail.com","xptmxm#1"))
        }.andDo {
            print()
        }.andExpect {
            status {
                isOk()
            }
        }.andReturn()

        val tokenDtoString = mvcResult.response.contentAsString
        val resTokenDto: Response<TokenDto> = objectMapper
            .readValue(tokenDtoString, object : TypeReference<Response<TokenDto>>() {})

        tokenDto = resTokenDto.data
    }
}