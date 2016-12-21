package com.candy.config;

import com.sun.management.OperatingSystemMXBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.management.ManagementFactory;

@Configuration
class ApplicationConfiguration {

    @Bean
    public OperatingSystemMXBean operatingSystemMXBean() {
        return ManagementFactory.getPlatformMXBean(OperatingSystemMXBean.class);
    }
}
