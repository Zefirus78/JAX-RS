package org.main.config;

import jakarta.ws.rs.core.Feature;
import jakarta.ws.rs.core.FeatureContext;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.jackson.internal.jackson.jaxrs.json.JacksonJaxbJsonProvider;
import org.main.repository.user.UserRepository;
import org.main.repository.user.UserRepositoryImpl;
import org.main.service.UserService;
import org.main.service.UserServiceImpl;

public class ApplicationBinder implements Feature {
    @Override
    public boolean configure(FeatureContext context) {
        context.register(new AbstractBinder() {
            @Override
            protected void configure() {
                bind(UserRepositoryImpl.class).to(UserRepository.class);
                bind(UserServiceImpl.class).to(UserService.class);
                bind(JacksonJaxbJsonProvider.class);
            }
        });
        return true;
    }
}
