package com.works.configs;

import org.aspectj.weaver.tools.cache.SimpleCache;
import org.modelmapper.ModelMapper;
import org.springframework.cache.CacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class AppBeans {

    @Bean
    public CacheManager cacheManager() {
        SimpleCacheManager simpleCacheManager = new SimpleCacheManager();
        simpleCacheManager.setCaches(
                Arrays.asList(
                        new ConcurrentMapCache("productList"),
                        new ConcurrentMapCache("noteList")
                )
        );
        return simpleCacheManager;
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}
