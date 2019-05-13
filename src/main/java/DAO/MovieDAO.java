package DAO;

import Models.Movie;
import Models.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.LinkedList;
import java.util.List;

public class MovieDAO {
    EntityManagerFactory factory;
    static EntityManager em;
    static List <Movie> movies=new LinkedList<Movie>();

    public MovieDAO() {
        factory = Persistence.createEntityManagerFactory("JPA-Zajecia");
        em = factory.createEntityManager();
        getAllMovies();
    }

    public static void getAllMovies() {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA-Zajecia");
        EntityManager em = factory.createEntityManager();
        try {
            Query q = em.createQuery("FROM Movie", Movie.class);
            movies = q.getResultList();
            for (Movie m : movies)
                System.out.println(m);
        }
        catch(Exception e) {
            System.err.println("Blad przy pobieraniu rekord—w: " + e);
        }

    }

    public static void deleteMovie(Long id){

        try {
            Movie foundMovie = em.find(Movie.class,id);
            DAO.delete(foundMovie,em);
        }

        catch (Exception e) {
            System.err.println("Error when trying to delete data from database: " + e);
            em.getTransaction().rollback();
        }

    }

    public static void addMovie(Movie m, Long user_id) {
        try {
            User foundUser = em.find(User.class, user_id);
            m.setUser(foundUser);
            DAO.add(m,em);
        }  catch(Exception e) {
            em.getTransaction().rollback();
            System.err.println("Error when trying to add data to database: " + e);
        }
    }
    public static void updateMovie(Movie m) {
        try {
            Movie foundMovie = em.find(Movie.class, m.getId());

            em.getTransaction().begin();
            foundMovie.setTitle(m.getTitle());
            foundMovie.setUrl(m.getUrl());
            foundMovie.setUser(m.getUser());
            em.getTransaction().commit();
        }  catch(Exception e) {
            em.getTransaction().rollback();
            System.err.println("Error when trying to update data in database: " + e);
        }
    }
    public static Movie getMovieById(Long id){
        return em.find(Movie.class,id);
    }

}
