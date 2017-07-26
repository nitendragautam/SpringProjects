package com.nitendragautam;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class Boot extends SpringBootServletInitializer {
    public static void main(String[] args) {
        new Boot()
            .configure(new SpringApplicationBuilder(Boot.class))
            .run(args);

    }
}
