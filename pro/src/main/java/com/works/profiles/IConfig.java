package com.works.profiles;

import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public interface IConfig {
    Map<EConfig, Object> config();
}
