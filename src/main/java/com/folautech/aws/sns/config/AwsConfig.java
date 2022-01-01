package com.folautech.aws.sns.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSClientBuilder;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Setter
@Slf4j
@Configuration
public class AwsConfig {

    @Value("${aws.deploy.region:us-west-2}")
    private String targetRegion;

    private Regions getTargetRegion() {
        if (targetRegion == null) {
            targetRegion = "us-west-2";
        }
        return Regions.fromName(targetRegion);
    }

    @Bean
    public AWSCredentialsProvider amazonAWSCredentialsProvider() {
        return new ProfileCredentialsProvider("folauk110");
    }

    @Bean
    public AmazonSNS amazonSNS() {
        return AmazonSNSClientBuilder.standard().withCredentials(amazonAWSCredentialsProvider()).withRegion(getTargetRegion()).build();
    }

}
