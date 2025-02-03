package com.example.demo.Config;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class RedisController {
private final messagepackRedis service;
//private final messagepackRedis mp;

    public RedisController(messagepackRedis service){ //messagepackRedis mp) {
        this.service = service;
       // this.mp = mp;
    }

    @GetMapping("/{key}")
    public Test getdata(@PathVariable("key") String key) {
        return service.getdata(key);
    }
    @PostMapping
    public String setvaluemessage(@RequestBody Test test) throws JsonProcessingException {
       // Test mytest=new Test("Nithishkumar","nithish");
        return service.insertdata(test);
    }

//    @GetMapping("mp/{key}")
//    public Test getdatamessae(@PathVariable("key") String key) {
//        return mp.getdata(key);
//    }
//    @PostMapping("mp")
//    public String setvalue(@RequestBody Test test) throws JsonProcessingException {
//        return mp.insertdata(test);
//    }

}
