package com.anyone.go_around_api.config.security

import com.anyone.go_around_jwt.token.JwtTokenProvider
import com.anyone.type.web.exception.InvalidTokenException
import org.apache.juli.logging.LogFactory
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.web.filter.OncePerRequestFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class JwtAuthenticationTokenFilter(
    private val userDetailService: UserDetailsService,
    private val jwtTokenProvider: JwtTokenProvider
): OncePerRequestFilter() {
    private val log = LogFactory.getLog(this.javaClass)

    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        var token: String? = request.getHeader("Authorization")
        if (token == null) {
            SecurityContextHolder.clearContext()
            filterChain.doFilter(request, response)
            return
        }

        if (token.startsWith("Bearer ")) {
            token = token.substring(7)
        }

        if (!jwtTokenProvider.validate(token)) {
            SecurityContextHolder.clearContext()
            throw InvalidTokenException("invalid token")
        }

        val email = token.let { jwtTokenProvider.getEmailFromToken(it) }
        if (SecurityContextHolder.getContext().authentication == null) {
            val userDetailService: UserDetails = userDetailService.loadUserByUsername(email)
            val authentication = UsernamePasswordAuthenticationToken(userDetailService, null, null)

            SecurityContextHolder.getContext().authentication = authentication
        }

        filterChain.doFilter(request, response)
    }
}