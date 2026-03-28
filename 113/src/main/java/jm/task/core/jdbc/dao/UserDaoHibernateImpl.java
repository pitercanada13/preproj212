
package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;

import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;


public class UserDaoHibernateImpl implements UserDao {
    public UserDaoHibernateImpl() {

    }


    @Override
    public void createUsersTable() {
        String sql = """
                CREATE TABLE IF NOT EXISTS users(
                id BIGSERIAL PRIMARY KEY,
                name VARCHAR(50),
                last_name VARCHAR(50),
                age SMALLINT)
                """;

        try (Session session = Util.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.createNativeQuery(sql).executeUpdate();
            session.getTransaction().commit();
        }
    }

    @Override
    public void dropUsersTable() {

        String sql = "DROP TABLE IF EXISTS users";

        try (Session session = Util.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.createNativeQuery(sql).executeUpdate();
            session.getTransaction().commit();
        }

    }

    @Override
    public void saveUser(String name, String lastName, byte age) {

        Transaction tx = null;

        try (Session session = Util.getSessionFactory().openSession()) {

            tx = session.beginTransaction();

            User user = new User(name, lastName, age);
            session.persist(user);

            tx.commit();

            //System.out.println("User с именем – " + name + " добавлен в базу данных");

        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }

    }

    @Override
    public void removeUserById(long id) {
        Transaction tx = null;

        try (Session session = Util.getSessionFactory().openSession()) {

            tx = session.beginTransaction();

            User user = session.get(User.class, id);
            if (user != null) {
                session.remove(user);
            }

            tx.commit();

        } catch (Exception e) {
            if (tx != null) tx.rollback();
        }

    }

    @Override
    public List<User> getAllUsers() {
        // List<User> users = null;

        try (Session session = Util.getSessionFactory().openSession()) {
            // users = session.createQuery("FROM User", User.class).list();
            return session.createQuery("from User", User.class).getResultList();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

       //return users;
        return List.of();
    }

    @Override
    public void cleanUsersTable() {
        try (Session session = Util.getSessionFactory().openSession()) {

            session.beginTransaction();
            session.createNativeQuery("TRUNCATE TABLE users").executeUpdate();
            session.getTransaction().commit();
        }
    }

    }


