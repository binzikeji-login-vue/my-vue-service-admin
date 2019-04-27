package com.binzikeji.my.vue.service.admin.service.fallback;

import com.binzikeji.my.vue.service.admin.service.RedisService;
import org.springframework.stereotype.Component;

@Component
public class RedisServiceFallback implements RedisService {

    @Override
    public String put(String key, String value, long seconds) {
        return null;
    }

    @Override
    public String get(String key) {
        return null;
    }
}
