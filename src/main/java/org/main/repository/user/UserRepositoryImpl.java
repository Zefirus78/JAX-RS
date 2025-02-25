package org.main.repository.user;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.MutationQuery;
import org.hibernate.query.Query;
import org.main.config.HibernateConfig;
import org.main.dto.user.request.UserDtoRequest;
import org.main.entity.User;

import java.util.List;
import java.util.Optional;

public class UserRepositoryImpl implements UserRepository {
    @Override
    public void save(UserDtoRequest request) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            String hql = "INSERT INTO User (firstName, lastName, email) " +
                    "VALUES (:firstName, lastName, :email)";
            MutationQuery mutationQuery = session.createMutationQuery(hql);
            mutationQuery.setParameter("firstName", request.firstName());
            mutationQuery.setParameter("lastName", request.lastName());
            mutationQuery.setParameter("email", request.email());
            mutationQuery.executeUpdate();

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    @Override
    public Optional<List<User>> getAll() {
        return Optional.empty();
    }

    @Override
    public Optional<User> getById(Long id) {
        return Optional.empty();
    }

    @Override
    public void update(Long id, UserDtoRequest request) {

    }

    @Override
    public boolean deleteById(Long id) {
        return false;
    }

    @Override
    public Optional<User> getLastEntity() {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            Query<User> query = session.createQuery("FROM User ORDER BY id DESC", User.class);
            query.setMaxResults(1);
            User user = query.uniqueResult();

            transaction.commit();
            return Optional.of(user);
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            return Optional.empty();
        }
    }

    @Override
    public Optional<List<User>> fetchByFirstName(String firstName) {
        return Optional.empty();
    }

    @Override
    public Optional<List<User>> fetchByLastName(String lastName) {
        return Optional.empty();
    }

    @Override
    public Optional<List<User>> fetchByEmail(String email) {
        return Optional.empty();
    }

    @Override
    public Optional<List<User>> fetchAllOrderBy(String orderBy) {
        return Optional.empty();
    }

    @Override
    public Optional<List<User>> fetchByLastNameOrderBy(String lastName, String orderBy) {
        return Optional.empty();
    }

    @Override
    public Optional<List<User>> fetchBetweenIds(Integer from, Integer to) {
        return Optional.empty();
    }

    @Override
    public Optional<List<User>> fetchLastNameIn(String lastName1, String lastName2) {
        return Optional.empty();
    }
}
