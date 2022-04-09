package com.anyone.go_around_api.category.adapter.`in`.web

import com.anyone.go_around_api.common.GoAroundV1APIController
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@GoAroundV1APIController
@RestController
class CategoryController {
    @GetMapping("/categories")
    fun categories(): String {
        return "categories";
    }
}