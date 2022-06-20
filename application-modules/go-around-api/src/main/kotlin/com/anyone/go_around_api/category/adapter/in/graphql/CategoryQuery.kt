package com.anyone.go_around_api.category.adapter.`in`.graphql

import com.anyone.go_around_api.category.adapter.`in`.web.CategoryDtoMapper
import com.anyone.go_around_api.category.adapter.`in`.web.response.CategoryDto
import com.anyone.go_around_api.category.application.port.`in`.CategoryUseCase
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.RestController

@RestController
class CategoryQuery(
    private val categoryUseCase: CategoryUseCase,
    private val categoryDtoMapper: CategoryDtoMapper
) {
    @QueryMapping
    @PreAuthorize("isAuthenticated()")
    fun categories(): List<CategoryDto> {
        val categoryVos = categoryUseCase.getAllCategory()

        return categoryDtoMapper.toCategoryDtoList(categoryVos)
    }
}