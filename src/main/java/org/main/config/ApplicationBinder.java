package org.main.config;

import jakarta.ws.rs.core.Feature;
import jakarta.ws.rs.core.FeatureContext;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.jackson.internal.jackson.jaxrs.json.JacksonJaxbJsonProvider;
import org.main.repository.UserRepository;
import org.main.repository.user.UserRepositoryImpl;

public class ApplicationBinder implements Feature {
    @Override
    public boolean configure(FeatureContext context) {
        context.register(new AbstractBinder() {
            @Override
            protected void configure() {
                bind(UserRepositoryImpl.class).to(UserRepository.class);
                bind(JacksonJaxbJsonProvider.class);
            }
        });
        return true;
    }
}
