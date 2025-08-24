package com.works.profiles;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Profile("comp1")
public class Comp1 implements IConfig {

    @Override
    public Map<EConfig, Object> config() {
        Map<EConfig, Object> map = new HashMap<>();
        map.put(EConfig.apiKey, "comp1apiKey");
        map.put(EConfig.baseURL, "comp1baseURL");
        map.put(EConfig.rowCount, "comp1rowCount");
        map.put(EConfig.cardNumber, "comp1cardNumber");
        return map;
    }

}
