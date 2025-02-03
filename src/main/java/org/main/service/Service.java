package org.main.service;

import java.util.List;

public interface Service <T, S>{
    T create(S request);

    List<T> getAll();

    T getById(Long id);

    T update(Long id, S request);

    boolean deleteById(Long id);
}
