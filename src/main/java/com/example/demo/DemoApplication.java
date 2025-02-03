package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
    private static boolean val=false;
    public static void main(String[] args) {

        //this line is written to check it from our end
        SpringApplication.run(DemoApplication.class, args);





    }

    @Override
    public void run(String... args) throws Exception {
        Thread t1 = new Thread(
                () -> {
                    boolean check = val;
                    while (!check) {
                        System.out.println(val);
                        check = val;
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
        );

        Thread t2 = new Thread(
                () -> {
                    val = true;
                }
        );
        t1.start();
        t2.start();

    }
}