package org.main.config;

import jakarta.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;
import org.main.controller.ProductController;
import org.main.controller.UserController;

@ApplicationPath("api/v1")
public class AppResourceConfig extends ResourceConfig {

    public AppResourceConfig() {
        register(UserController.class);
        register(ProductController.class);
        register(ApplicationBinder.class);
    }
}
