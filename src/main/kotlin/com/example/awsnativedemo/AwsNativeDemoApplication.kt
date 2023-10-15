package com.example.awsnativedemo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication

@SpringBootApplication
@ConfigurationPropertiesScan
class AwsNativeDemoApplication

fun main(args: Array<String>) {
    runApplication<AwsNativeDemoApplication>(*args)
}
