package com.example.awsnativedemo

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties("credentials.aws")
data class AwsCredentials(
    val accessKey: String,
    val secretKey: String
)