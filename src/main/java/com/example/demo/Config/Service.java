//package com.example.demo.Config;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.redis.core.RedisTemplate;
//
//import java.io.IOException;
//
//@org.springframework.stereotype.Service
//public class Service {
//    @Autowired
//    public RedisTemplate redisTemplate;
//    @Autowired
//    private ObjectMapper objectMapper;
//
//
//    public String insertdata(Test test) throws JsonProcessingException {
//        // Serialize the Test object using the objectMapper
//        redisTemplate.opsForValue().set(test.key, objectMapper.writeValueAsString(test));
//        return "insert successful";
//    }
//
//    public Test getdata(String key) {
//        Object val=  redisTemplate.opsForValue().get(key);
//        if(val!=null) {
//            try {
//                return objectMapper.readValue(val.toString(),Test.class);
//            } catch (JsonProcessingException e) {
//                throw new RuntimeException(e);
//            }
//        }
//        return null;
//
//        // Retrieve the value from Redis and deserialize it into a Test object
//        // Return null if not found or deserialization failed
//    }
//
//}
