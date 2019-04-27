package com.binzikeji.my.vue.service.admin.service;

import com.binzikeji.my.vue.service.admin.service.fallback.RedisServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Service
@FeignClient(value = "my-vue-service-redis", fallback = RedisServiceFallback.class)
public interface RedisService {

    @RequestMapping(value = "put", method = RequestMethod.GET)
    String put (@RequestParam(value = "key") String key, @RequestParam(value = "value") String value, @RequestParam(value = "seconds") long seconds);

    @RequestMapping(value = "get", method = RequestMethod.GET)
    String get(@RequestParam(value = "key") String key);
}
