package com.deeponcode.springcoredemo.config;

import com.deeponcode.springcoredemo.common.Coach;
import com.deeponcode.springcoredemo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {

    @Bean("aquatic")
    public Coach swimCoach(){
        return new SwimCoach();
    }
}
