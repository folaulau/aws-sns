package com.folautech.aws.sns;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.amazonaws.services.sns.AmazonSNS;
import com.folautech.aws.sns.config.AwsConfig;

@SpringBootTest
class AwsSnsApplicationTests {

    @Autowired
    AwsConfig awsConfig;

    @BeforeEach
    void setup() {

    }

    @Test
    void sendText() {

        AmazonSNS amazonSNS = awsConfig.amazonSNS();

    }

}
