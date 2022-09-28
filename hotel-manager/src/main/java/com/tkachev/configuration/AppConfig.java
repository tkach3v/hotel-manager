package com.tkachev.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


@Configuration

@PropertySource("classpath:config.properties")
@ComponentScan({"com.tkachev.service", "com.tkachev.mapper", "com.tkachev.exception_handling"})
public class AppConfig {

}
