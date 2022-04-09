package com.anyone.go_around_api.category.adapter.out

import com.anyone.go_around_api.category.application.port.out.LoadCategoryPort
import com.anyone.mysql_domain.category.CategoryRepository
import org.springframework.stereotype.Service

@Service
class CategoryPersistenceAdapter(
    private val categoryRepository: CategoryRepository
): LoadCategoryPort {
    override fun findAllCategory() {
        categoryRepository.findAll()
    }
}