package com.anyone.anyoneapiserver.feed.adapter.`in`.web

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class FeedController {
    @GetMapping("/feeds")
    fun feeds(): String {
        return "feeds";
    }
}