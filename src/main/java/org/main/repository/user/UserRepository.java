package org.main.repository.user;

import org.main.dto.user.request.UserDtoRequest;
import org.main.entity.User;
import org.main.repository.Repository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends Repository<User, UserDtoRequest> {
    void save(UserDtoRequest request);

    Optional<List<User>> getAll();

    Optional<User> getById(Long id);

    void update(Long id, UserDtoRequest request);

    boolean deleteById(Long id);

    Optional<User> getLastEntity();

    Optional<List<User>> fetchByFirstName(String firstName);
    Optional<List<User>> fetchByLastName(String lastName);
    Optional<List<User>> fetchByEmail(String email);
    Optional<List<User>> fetchAllOrderBy(String orderBy);
    Optional<List<User>> fetchByLastNameOrderBy(String lastName, String orderBy);
    Optional<List<User>> fetchBetweenIds(Integer from, Integer to);
    Optional<List<User>> fetchLastNameIn(String lastName1, String lastName2);
}
