package com.example.testdemo.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;
import java.util.Collections;

@Configuration
@Slf4j
public class ApiConfig {

    @Value("${stage1.baseUrl}")
    private String baseUrl;

    @Bean
    protected RestTemplate restTemplate(){
        log.info("Base url is : {}", baseUrl);
        return restTemplateBuilder()
                .rootUri(baseUrl)
                .setConnectTimeout(Duration.ofMinutes(1))
                .messageConverters(Collections.singletonList(
                        new MappingJackson2HttpMessageConverter()))
                .build();
    }

    @Bean
    protected RestTemplateBuilder restTemplateBuilder(){
        return new RestTemplateBuilder();
    }
}
