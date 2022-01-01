package com.folautech.aws.sns;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.PublishRequest;
import com.amazonaws.services.sns.model.PublishResult;
import com.folautech.aws.sns.config.AwsConfig;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class AwsSnsApplicationTests {

    @Autowired
    AwsConfig awsConfig;

    @BeforeEach
    void setup() {

    }

    /**
     * https://docs.aws.amazon.com/sns/latest/dg/sms_publish-to-phone.html
     */
    @Test
    void sendText() {

        AmazonSNS amazonSNS = awsConfig.amazonSNS();

        try {
            PublishRequest request = new PublishRequest();
            request.setMessage("hello world!");
            request.setPhoneNumber("13109934731");

            PublishResult result = amazonSNS.publish(request);

            log.info("messageId={}", result.getMessageId());
            log.info("sequenceNumber={}", result.getSequenceNumber());

        } catch (Exception e) {
            log.warn(e.getLocalizedMessage());
        }

    }

}
