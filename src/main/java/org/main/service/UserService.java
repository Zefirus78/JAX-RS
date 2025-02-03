package org.main.service;

import org.main.dto.user.request.UserDtoRequest;
import org.main.entity.User;

import java.util.List;

public interface UserService extends Service<User, UserDtoRequest>{

    User create(UserDtoRequest request);

    List<User> getAll();

    User getById(Long id);

    User update(Long id, UserDtoRequest request);

    boolean deleteById(Long id);

    List<User> fetchByFirstName(String firstName);
    List<User> fetchByLastName(String lastName);
    List<User> fetchByEmail(String email);
}
