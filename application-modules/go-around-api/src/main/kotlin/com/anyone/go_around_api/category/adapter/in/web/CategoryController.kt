package com.anyone.go_around_api.category.adapter.`in`.web

import com.anyone.go_around_api.category.adapter.`in`.web.response.CategoryDto
import com.anyone.go_around_api.category.application.port.`in`.CategoryUseCase
import com.anyone.go_around_api.common.GoAroundV1APIController
import com.anyone.type.web.response.Response
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@GoAroundV1APIController
@RestController
class CategoryController(
    private val categoryUseCase: CategoryUseCase,
    private val categoryDtoMapper: CategoryDtoMapper
) {
    @GetMapping("/categories")
    fun categories(): Response<List<CategoryDto>> {
        val categoryVos = categoryUseCase.getAllCategory()
        val categoryDtoList = categoryDtoMapper.toCategoryDtoList(categoryVos)

        return Response(categoryDtoList)
    }
}