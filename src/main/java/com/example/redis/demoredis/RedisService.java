package com.example.redis.demoredis;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RedisService {
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    public String saveData(String id, Object obj) {
        String jsonObj = "";
        try {
            jsonObj = objectMapper.writeValueAsString(obj);
            System.out.println(jsonObj);
        } catch (JsonProcessingException jpe) {
            log.error(jpe.getMessage(), jpe);
        }
        redisTemplate.opsForValue().set(id, jsonObj);

        return id;
    }

    public String getData(String key) {
        return redisTemplate.opsForValue().get(key);
    }
}
