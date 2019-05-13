package DAO;

import Models.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.LinkedList;
import java.util.List;

public class UserDAO {
    EntityManagerFactory factory;
    static EntityManager em;
    static List <User> users=new LinkedList<User>();

    public UserDAO() {
        factory = Persistence.createEntityManagerFactory("JPA-Zajecia");
        em = factory.createEntityManager();
        getAllUsers();
    }

    public static void getAllUsers() {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA-Zajecia");
        EntityManager em = factory.createEntityManager();
        try {
            Query q = em.createQuery("FROM User", User.class);
            users = q.getResultList();
            for (User u : users)
                System.out.println(u);
        }
        catch(Exception e) {
            System.err.println("Blad przy pobieraniu rekord—w: " + e);
        }

    }

    public static void deleteUser(Long id){

        try {
            User foundUser = em.find(User.class, id);
            DAO.delete(foundUser,em);
        }

        catch (Exception e) {
            System.err.println("Error when trying to delete data from database: " + e);
            em.getTransaction().rollback();
        }

    }

    public static void addUser(User u) {
        try {
            DAO.add(u,em);
        }  catch(Exception e) {
            em.getTransaction().rollback();
            System.err.println("Error when trying to add data to database: " + e);
        }
    }
    public static void updateUser(User user) {
        try {
            User foundUser = em.find(User.class, user.getId());

            em.getTransaction().begin();
            foundUser.setName(user.getName());
            foundUser.setAge(user.getAge());
            foundUser.setAvatar(user.getAvatar());
            em.getTransaction().commit();
        }  catch(Exception e) {
            em.getTransaction().rollback();
            System.err.println("Error when trying to update data in database: " + e);
        }
    }

    public static User getUserById(Long id){
        return em.find(User.class,id);
    }

}
