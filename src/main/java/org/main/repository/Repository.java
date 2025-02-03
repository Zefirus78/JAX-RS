package org.main.repository;

import org.main.entity.User;

import java.util.List;
import java.util.Optional;

public interface Repository<T, S>{
    void save(S request);

    Optional<List<User>> getAll();

    Optional<T> getById(Long id);

    void update(Long id, S request);

    boolean deleteById(Long id);
}
