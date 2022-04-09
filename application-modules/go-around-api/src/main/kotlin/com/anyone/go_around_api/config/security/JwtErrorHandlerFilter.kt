package com.anyone.go_around_api.config.security

import com.anyone.go_around_api.exception.ErrorResponse
import com.anyone.type.web.exception.InvalidTokenException
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.http.MediaType
import org.springframework.web.filter.OncePerRequestFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class JwtErrorHandlerFilter(
    private val objectMapper: ObjectMapper
): OncePerRequestFilter() {
    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        try {
            filterChain.doFilter(request, response)
        } catch (ex: InvalidTokenException) {
            val errorResponse = ErrorResponse("Unauthorized")
            val errorJsonString: String = objectMapper.writeValueAsString(errorResponse)

            response.status = 401
            response.contentType = MediaType.APPLICATION_JSON_VALUE
            response.writer.write(errorJsonString)
        }
    }
}