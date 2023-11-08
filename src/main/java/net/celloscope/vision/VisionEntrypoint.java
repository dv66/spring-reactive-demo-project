package net.celloscope.vision;


import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/*
* Reference: https://github.com/kamalhm/spring-boot-r2dbc/tree/master
* */

@SpringBootApplication
@Slf4j
public class VisionEntrypoint {

    public static void main(String[] args) {
        SpringApplication.run(VisionEntrypoint.class, args);
    }

}