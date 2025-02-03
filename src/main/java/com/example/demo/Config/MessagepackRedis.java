package com.example.demo.Config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
class messagepackRedis {

    @Autowired
    private RedisTemplate<String, byte[]> redisTemplate;

    @Autowired
    private ObjectMapper messagePackObjectMapper;

    public String insertdata(Test test) {
        try {
            // Serialize Test object to MessagePack format
            byte[] serializedData = messagePackObjectMapper.writeValueAsBytes(test);
            redisTemplate.opsForValue().set(test.getKey(), serializedData);
            return "Insert successful using messagepeak";
        } catch (Exception e) {
            e.printStackTrace();
            return "Error during insert";
        }
    }

    public Test getdata(String key) {
        try {
            // Retrieve MessagePack data from Redis
            byte[] data = redisTemplate.opsForValue().get(key);
            if (data != null) {
                // Deserialize MessagePack data to Test object
                return messagePackObjectMapper.readValue(data, Test.class);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null; // Return null if not found or deserialization fails
    }
}
