package com.anyone.go_around_api.category.adapter.`in`.web

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class CategoryController {
    @GetMapping("/categories")
    fun categories(): String {
        return "categories";
    }
}