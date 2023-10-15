package com.example.awsnativedemo

import com.amazonaws.services.s3.AmazonS3
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

// For test purposes
@RestController
class TestController(private val s3: AmazonS3) {

    @GetMapping
    fun test(): ResponseEntity<*> {
        val buckets = s3.listBuckets().map { it.name }

        return ResponseEntity.ok(buckets)
    }
}