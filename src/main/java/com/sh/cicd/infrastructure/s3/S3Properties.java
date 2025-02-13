package com.sh.cicd.infrastructure.s3;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties(prefix = "aws.s3")
@Configuration
@Getter
@Setter
public class S3Properties {

    private String bucketName;
    private String region;
}
