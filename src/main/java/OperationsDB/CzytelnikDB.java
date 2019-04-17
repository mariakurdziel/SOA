package OperationsDB;

import Model.Autor;
import Model.Czytelnik;
import Model.Ksiazka;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.io.Reader;
import java.util.LinkedList;
import java.util.List;

@ManagedBean(name="CzytelnikDB")
@RequestScoped
public class CzytelnikDB {

    EntityManagerFactory factory;
    EntityManager em;
    List<Czytelnik> readers=new LinkedList<Czytelnik>();
    Czytelnik newCzytelnik;
    Czytelnik editedCzytelnik;

    public CzytelnikDB() {
        factory = Persistence.createEntityManagerFactory("JPA-Zajecia");
        em = factory.createEntityManager();
        getAllReaders();
    }

    public List<Czytelnik> getReaders() {
        return readers;
    }

    public void setReaders(List<Czytelnik> readers) {
        this.readers = readers;
    }

    public Czytelnik findById(Long id){
        try {
            return this.em.find(Czytelnik.class, id);
        }
        catch(Exception e){
            this.em.getTransaction().rollback();
            System.out.println(e.toString());
            return null;
        }


    }

    public void getAllReaders() {

        newCzytelnik=new Czytelnik("","");

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA-Zajecia");
        EntityManager em = factory.createEntityManager();
        try {
            Query q = em.createQuery("FROM Czytelnik", Czytelnik.class);
            readers = q.getResultList();
            for (Czytelnik r: readers)
                System.out.println(r);
        }
        catch(Exception e) {
            System.err.println("Blad przy pobieraniu rekord—w: " + e);
        }

    }

    public void deleteReader(Czytelnik r){

        try {
            Czytelnik foundReader= em.find(Czytelnik.class, r.getId_czytelnika());

            em.getTransaction().begin();
            em.remove(foundReader);
            em.getTransaction().commit();
            getAllReaders();
        }

        catch (Exception e) {
            System.err.println("Error when trying to delete data from database: " + e);
            em.getTransaction().rollback();
        }

    }

    public String addReader() {
        try {
            em.getTransaction().begin();
            em.merge(newCzytelnik);
            em.getTransaction().commit();
            getAllReaders();
            return "index";
        }  catch(Exception e) {
            em.getTransaction().rollback();
            System.err.println("Error when trying to add data to database: " + e);
            return "";
        }
    }
    public String updateReader() {
        try {
            Czytelnik foundReader = em.find(Czytelnik.class, editedCzytelnik.getId_czytelnika());

            em.getTransaction().begin();
            foundReader.setName(editedCzytelnik.getName());
            foundReader.setSurname(editedCzytelnik.getSurname());
            em.getTransaction().commit();
            getAllReaders();
            return "index";
        }  catch(Exception e) {
            em.getTransaction().rollback();
            System.err.println("Error when trying to update data in database: " + e);
            return "";
        }
    }

    public String editReader(Czytelnik c){
        editedCzytelnik=c;
        return "edit";
    }

}
