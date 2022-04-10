package com.anyone.go_around_api.category.application.port.`in`

import com.anyone.go_around_api.category.application.service.vo.CategoryVo

interface CategoryUseCase {
    fun getAllCategory(): List<CategoryVo>
}