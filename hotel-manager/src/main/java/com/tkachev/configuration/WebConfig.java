package com.tkachev.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebMvc
@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true)
@ComponentScan("com.tkachev.controller")
public class WebConfig implements WebMvcConfigurer {

}
