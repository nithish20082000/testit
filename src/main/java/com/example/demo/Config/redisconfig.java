package com.example.demo.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class redisconfig {





        @Bean
        public RedisTemplate<String, byte[]> redisTemplate(RedisConnectionFactory factory) {
            RedisTemplate<String, byte[]> redisTemplate = new RedisTemplate<>();
            redisTemplate.setConnectionFactory(factory);

            // Use StringRedisSerializer for keys
            redisTemplate.setKeySerializer(new StringRedisSerializer());
            redisTemplate.setHashKeySerializer(new StringRedisSerializer());

            // Use ByteArrayRedisSerializer for values
            redisTemplate.setValueSerializer(new RedisSerializer<byte[]>() {
                @Override
                public byte[] serialize(byte[] value) {
                    return value;
                }

                @Override
                public byte[] deserialize(byte[] bytes) {
                    return bytes;
                }
            });

            return redisTemplate;
        }

}
