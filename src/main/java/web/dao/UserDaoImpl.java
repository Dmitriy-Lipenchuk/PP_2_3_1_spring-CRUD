package web.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.models.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    private final EntityManagerFactory entityManagerFactory;

    @Autowired
    public UserDaoImpl(EntityManagerFactory entityManager) {
        this.entityManagerFactory = entityManager;
    }

    @Override
    public void addUser(User user) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            entityManager.getTransaction().begin();
            entityManager.persist(user);
            entityManager.flush();
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }
    }

    @Override
    public void removeUser(int id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        User user = entityManager.find(User.class, id);

        try {
            entityManager.getTransaction().begin();
            entityManager.remove(user);
            entityManager.flush();
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }
    }

    @Override
    public void updateUser(User user) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            entityManager.getTransaction().begin();
            entityManager.merge(user);
            entityManager.flush();
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }
    }

    @Override
    public User getUser(int id) {
        User user = null;
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            user = entityManager.find(User.class, id);
        } finally {
            entityManager.close();
        }

        return user;
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = null;
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            users = entityManager.createQuery("select u from User u", User.class).getResultList();
        } finally {
            entityManager.close();
        }

        return users;
    }
}
