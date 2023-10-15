package com.example.awsnativedemo

import com.amazonaws.auth.AWSStaticCredentialsProvider
import com.amazonaws.auth.BasicAWSCredentials
import com.amazonaws.regions.Regions
import com.amazonaws.services.s3.AmazonS3
import com.amazonaws.services.s3.AmazonS3ClientBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class S3ClientConfig(private val awsCredentials: AwsCredentials) {

    @Bean
    fun s3Client(): AmazonS3 {
        val basicCredentials = BasicAWSCredentials(awsCredentials.accessKey, awsCredentials.secretKey)
        val credentialsProvider = AWSStaticCredentialsProvider(basicCredentials)

        return AmazonS3ClientBuilder.standard()
            .withCredentials(credentialsProvider)
            .withRegion(Regions.EU_CENTRAL_1)
            .build()
    }
}