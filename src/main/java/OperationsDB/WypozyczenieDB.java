package OperationsDB;

import Model.Wypozyczenie;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.LinkedList;
import java.util.List;

@ManagedBean(name="WypozyczenieDB")
@RequestScoped
public class WypozyczenieDB {

    EntityManagerFactory factory;
    EntityManager em;
    static Wypozyczenie editedRental;
    static Wypozyczenie newRental=new Wypozyczenie(null,null,null,null);
    public List<Wypozyczenie> rentals=new LinkedList<Wypozyczenie>();

    public static Wypozyczenie getNewRental() {
        return newRental;
    }

    public static void setNewRental(Wypozyczenie newRental) {
        WypozyczenieDB.newRental = newRental;
    }

    public List<Wypozyczenie> getRentals() {
        return rentals;
    }

    public void setRentals(List<Wypozyczenie> rentals) {
        this.rentals = rentals;
    }

    public WypozyczenieDB() {
        factory = Persistence.createEntityManagerFactory("JPA-Zajecia");
        em = factory.createEntityManager();
        getAllRentals();
    }

    public void getAllRentals() {

        newRental=new Wypozyczenie(null,null,null,null);

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA-Zajecia");
        EntityManager em = factory.createEntityManager();
        try {
            Query q = em.createQuery("FROM Wypozyczenie", Wypozyczenie.class);
            rentals= q.getResultList();
            for (Wypozyczenie w : rentals)
                System.out.println(w);
        }
        catch(Exception e) {
            System.err.println("Blad przy pobieraniu rekord—w: " + e);
        }

    }

    public void deleteRental(Wypozyczenie w){

        try {
            Wypozyczenie foundRental = em.find(Wypozyczenie.class, w.getId());

            em.getTransaction().begin();
            em.remove(foundRental);
            em.getTransaction().commit();
            getAllRentals();
        }

        catch (Exception e) {
            System.err.println("Error when trying to delete data from database: " + e);
            em.getTransaction().rollback();
        }

    }

    public String addRental() {
        try {
            em.getTransaction().begin();
            em.merge(newRental);
            em.getTransaction().commit();
            getAllRentals();
            return "index";
        }  catch(Exception e) {
            em.getTransaction().rollback();
            System.err.println("Error when trying to add data to database: " + e);
            return "";
        }
    }
    public String updateRental() {
        try {
            Wypozyczenie foundRental = em.find(Wypozyczenie.class, editedRental.getId());

            em.getTransaction().begin();
            foundRental.setCzytelnik(editedRental.getCzytelnik());
            foundRental.setKsiazka(editedRental.getKsiazka());
            foundRental.setWypozyczenie(editedRental.getWypozyczenie());
            foundRental.setOddania(editedRental.getOddania());
            em.getTransaction().commit();
            getAllRentals();
            return "index";
        }  catch(Exception e) {
            em.getTransaction().rollback();
            System.err.println("Error when trying to update data in database: " + e);
            return "";
        }
    }

    public String editWypozyczenie(Wypozyczenie w){
        editedRental=w;
        return "edit";
    }
}
