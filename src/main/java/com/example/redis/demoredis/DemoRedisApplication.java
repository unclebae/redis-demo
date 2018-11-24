package com.example.redis.demoredis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootApplication
public class DemoRedisApplication implements CommandLineRunner {


    @Autowired
    RedisService redisService;

    @Autowired
    RedisTemplate<String, String> redisTemplate;

    public static void main(String[] args) {
        SpringApplication.run(DemoRedisApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        final String KEY = "KIDO";

        redisService.saveData(KEY, "Hello");

        System.out.println(String.format("Key: %s, Value: %s", "KIDO", redisService.getData("KIDO")));
    }
}
