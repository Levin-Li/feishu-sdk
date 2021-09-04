package com.levin.feishu.sdk;


import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;


@SpringBootConfiguration
@EnableAutoConfiguration
@EnableFeignClients
@ComponentScan("com.levin.feishu")
public class SdkTestConfiguration {


}
