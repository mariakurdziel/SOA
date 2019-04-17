package OperationsDB;

import Model.Autor;
import Model.Ksiazka;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.LinkedList;
import java.util.List;

@ManagedBean(name="AutorDB")
@RequestScoped
public class AutorDB {

    EntityManagerFactory factory;
    EntityManager em;
    List<Autor> authors=new LinkedList<Autor>();
    Autor newAutor;
    Autor editedAutor;

    public AutorDB() {
        factory = Persistence.createEntityManagerFactory("JPA-Zajecia");
        em = factory.createEntityManager();
        getAllAuthors();
    }

    public List<Autor> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Autor> authors) {
        this.authors = authors;
    }

    public Autor findById(Long id){
        try {
            return this.em.find(Autor.class, id);
        }
        catch(Exception e){
            this.em.getTransaction().rollback();
            System.out.println(e.toString());
            return null;
        }


    }

    public void getAllAuthors() {

        newAutor=new Autor("");

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA-Zajecia");
        EntityManager em = factory.createEntityManager();
        try {
            Query q = em.createQuery("FROM Autor", Autor.class);
            authors = q.getResultList();
            for (Autor a : authors)
                System.out.println(a);
        }
        catch(Exception e) {
            System.err.println("Blad przy pobieraniu rekord—w: " + e);
        }

    }

    public void deleteAuthor(Autor a){

        try {
            Autor foundAutor= em.find(Autor.class, a.getId_autora());

            em.getTransaction().begin();
            em.remove(foundAutor);
            em.getTransaction().commit();
            getAllAuthors();
        }

        catch (Exception e) {
            System.err.println("Error when trying to delete data from database: " + e);
            em.getTransaction().rollback();
        }

    }

    public String addBook() {
        try {
            em.getTransaction().begin();
            em.merge(newAutor);
            em.getTransaction().commit();
            getAllAuthors();
            return "books";
        }  catch(Exception e) {
            em.getTransaction().rollback();
            System.err.println("Error when trying to add data to database: " + e);
            return "";
        }
    }
    public String updateAutor(String imie, Ksiazka ksiazka) {
        try {
            Autor foundAutor = em.find(Autor.class, editedAutor.getId_autora());

            em.getTransaction().begin();
            foundAutor.setName(imie);
            foundAutor.getKsiazki().add(ksiazka);
            em.getTransaction().commit();
            getAllAuthors();
            return "index";
        }  catch(Exception e) {
            em.getTransaction().rollback();
            System.err.println("Error when trying to update data in database: " + e);
            return "";
        }
    }

    public String setEditedAutor(Autor a){
        editedAutor=a;
        return "edit";
    }

}
