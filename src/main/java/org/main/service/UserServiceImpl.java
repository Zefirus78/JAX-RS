package org.main.service;

import jakarta.inject.Inject;
import org.main.dto.user.request.UserDtoRequest;
import org.main.entity.User;
import org.main.repository.UserRepository;

import java.util.List;
import java.util.Objects;

public class UserServiceImpl implements UserService {
    @Inject
    private UserRepository userRepository;

    @Override
    public User create(UserDtoRequest request) {

        Objects.requireNonNull(request, "Parameter [request] must not be null");
        userRepository.save(request);

        return userRepository.getLastEntity().orElse(null);
    }

    @Override
    public List<User> getAll() {
        return List.of();
    }

    @Override
    public User getById(Long id) {
        return null;
    }

    @Override
    public User update(Long id, UserDtoRequest request) {
        return null;
    }

    @Override
    public boolean deleteById(Long id) {
        return false;
    }

    @Override
    public List<User> fetchByFirstName(String firstName) {
        return List.of();
    }

    @Override
    public List<User> fetchByLastName(String lastName) {
        return List.of();
    }

    @Override
    public List<User> fetchByEmail(String email) {
        return List.of();
    }
}
