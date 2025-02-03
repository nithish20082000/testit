package com.example.demo.Config;

import com.fasterxml.jackson.databind.ObjectMapper;
//import org.msgpack.MessagePack;
import org.msgpack.jackson.dataformat.MessagePackFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public ObjectMapper messagePackObjectMapper() {
        return new ObjectMapper(new MessagePackFactory());
    }
}
