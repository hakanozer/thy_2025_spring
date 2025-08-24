package com.works.profiles;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Profile("comp2")
public class Comp2 implements IConfig {

    @Override
    public Map<EConfig, Object> config() {
        Map<EConfig, Object> map = new HashMap<>();
        map.put(EConfig.apiKey, "comp2apiKey");
        map.put(EConfig.baseURL, "comp2baseURL");
        map.put(EConfig.rowCount, "comp2rowCount");
        map.put(EConfig.cardNumber, "comp2cardNumber");
        return map;
    }

}
