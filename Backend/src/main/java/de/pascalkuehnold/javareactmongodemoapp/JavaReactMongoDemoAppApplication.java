package de.pascalkuehnold.javareactmongodemoapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JavaReactMongoDemoAppApplication {

    public static void main(String[] args) {

        SpringApplication.run(JavaReactMongoDemoAppApplication.class, args);

        String envVar = System.getenv().get("spring.data.mongodb.database");

        System.out.println(envVar);
    }


}
