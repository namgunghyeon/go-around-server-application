package com.anyone.go_around_api.category.adapter.`in`.web

import com.anyone.go_around_api.category.adapter.`in`.web.response.CategoryDto
import com.anyone.go_around_api.category.application.service.vo.CategoryVo
import com.anyone.go_around_api.common.Mapper

@Mapper
class CategoryDtoMapper {
    fun toCategoryDtoList(categoryVos: List<CategoryVo>): List<CategoryDto> {
        return categoryVos.stream()
            .map { CategoryDto(it.id, it.code) }
            .toList()
    }
}