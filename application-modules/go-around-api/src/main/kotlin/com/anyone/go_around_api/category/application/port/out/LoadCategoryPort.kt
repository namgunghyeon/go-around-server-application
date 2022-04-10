package com.anyone.go_around_api.category.application.port.out

import com.anyone.mysql_domain.category.Category

interface LoadCategoryPort {
    fun findAllCategory(): List<Category>
}