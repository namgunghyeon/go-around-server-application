package com.anyone.go_around_api.config.security

import com.anyone.go_around_jwt.token.JwtTokenProvider
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter


@Configuration
@EnableWebSecurity
class WebSecurityConfig(): WebSecurityConfigurerAdapter() {
    @Autowired
    lateinit var objectMapper: ObjectMapper
    @Autowired
    lateinit var jwtTokenProvider: JwtTokenProvider
    @Autowired
    lateinit var userDetailsService: UserDetailsService

    companion object {
        val EXCLUDED_PATHS = arrayOf(
            "/api/v1/accounts/sign-up",
            "/api/v1/accounts/sign-in"
        )
    }

    @Bean
    fun passwordEncoder(): PasswordEncoder {
        return BCryptPasswordEncoder()
    }

    fun configureAuthentication(authenticationManagerBuilder: AuthenticationManagerBuilder) {
        authenticationManagerBuilder
            .userDetailsService(userDetailsService)
            .passwordEncoder(passwordEncoder())
    }

    @Bean
    override fun authenticationManagerBean(): AuthenticationManager {
        return super.authenticationManagerBean()
    }

    @Bean
    fun jwtAuthenticationTokenFilter(): JwtAuthenticationTokenFilter {
        return JwtAuthenticationTokenFilter(userDetailsService, jwtTokenProvider)
    }

    @Bean
    fun jwtHandlerFilter(): JwtErrorHandlerFilter{
        return JwtErrorHandlerFilter(objectMapper)
    }

    override fun configure(http: HttpSecurity) {
        http.csrf().disable()
            .logout().disable()
            .authorizeRequests()
            .antMatchers(*EXCLUDED_PATHS).permitAll()
            .anyRequest().authenticated()

        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        http.addFilterBefore(jwtAuthenticationTokenFilter(), UsernamePasswordAuthenticationFilter::class.java)
        http.addFilterBefore(jwtHandlerFilter(), JwtAuthenticationTokenFilter::class.java)
        http.headers().frameOptions().disable()
        http.headers().cacheControl()
    }
}