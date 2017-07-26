package com.nitendragautam.config;

import com.nitendragautam.controller.PersonController;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import javax.ws.rs.ApplicationPath;

/*
Application Config

 */
@Component
@ApplicationPath("/app")
public class ApplicationConfig extends ResourceConfig {

    public ApplicationConfig() {
        register(PersonController.class);
    }

}