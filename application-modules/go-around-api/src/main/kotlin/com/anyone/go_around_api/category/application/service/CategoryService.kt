package com.anyone.go_around_api.category.application.service

import com.anyone.go_around_api.category.application.port.`in`.CategoryUseCase
import com.anyone.go_around_api.category.application.port.out.LoadCategoryPort
import com.anyone.go_around_api.category.application.service.vo.CategoryVo
import org.springframework.stereotype.Service

@Service
class CategoryService(
    private val loadCategoryPort: LoadCategoryPort
): CategoryUseCase {
    override fun getAllCategory(): List<CategoryVo> {
        return loadCategoryPort.findAllCategory()
            .map { CategoryVo(it.id, it.code, it.displayName) }
            .toMutableList()
    }
}