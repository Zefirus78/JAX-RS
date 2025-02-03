package org.main.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.main.dto.user.request.UserDtoRequest;
import org.main.entity.User;
import org.main.service.UserService;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
public class UserController {
    @Inject
    private UserService userService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createUser(final UserDtoRequest request) {
        User user = userService.create(request);

        if (user != null) {
            return Response.ok().entity(request).build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }
}
