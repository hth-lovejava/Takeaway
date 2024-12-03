package com.takeaway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class TakeawayTakeawayApplication {

    public static void main(String[] args) {
        SpringApplication.run(TakeawayTakeawayApplication.class, args);
    }

}
