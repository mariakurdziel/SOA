import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader;
import example.Student;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.xml.bind.SchemaOutputResolver;
import java.util.LinkedList;
import java.util.List;

@ManagedBean(name="Manager")
@RequestScoped
public class Manager {
    EntityManagerFactory factory;
    EntityManager em;
    static Ksiazka editedBook;
    static Ksiazka newBook=new Ksiazka("","","","","","");
    List <Ksiazka> books=new LinkedList<Ksiazka>();

    public Ksiazka getNewBook() {
        return newBook;
    }

    public void setNewBook(Ksiazka newBook) {
        this.newBook = newBook;
    }
    public Ksiazka getEditedBook() {
        return editedBook;
    }

    public void setEditedBook(Ksiazka editedBook) {
        this.editedBook = editedBook;
    }

    public List<Ksiazka> getBooks() {
        return books;
    }

    public void setBooks(List<Ksiazka> books) {
        this.books = books;
    }

    public Manager() {
        factory = Persistence.createEntityManagerFactory("JPA-Zajecia");
        em = factory.createEntityManager();
        getAllBooks();
    }

    public void getAllBooks() {

        newBook=new Ksiazka("","","","","","");

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA-Zajecia");
        EntityManager em = factory.createEntityManager();
        try {
            Query q = em.createQuery("FROM Ksiazka", Ksiazka.class);
            books = q.getResultList();
            for (Ksiazka k : books)
                System.out.println(k);
        }
        catch(Exception e) {
            System.err.println("Blad przy pobieraniu rekord—w: " + e);
        }

    }

    public void deleteBook(Ksiazka k){

        try {
            Ksiazka foundBook = em.find(Ksiazka.class, k.id);

            em.getTransaction().begin();
            em.remove(foundBook);
            em.getTransaction().commit();
            getAllBooks();
        }

        catch (Exception e) {
            System.err.println("Error when trying to delete data from database: " + e);
            em.getTransaction().rollback();
        }

    }

    public String addBook() {
        try {
            em.getTransaction().begin();
            em.merge(newBook);
            em.getTransaction().commit();
            getAllBooks();
            return "books";
        }  catch(Exception e) {
            em.getTransaction().rollback();
            System.err.println("Error when trying to add data to database: " + e);
            return "";
        }
    }
    public String updateBook() {
        try {
            Ksiazka foundBook = em.find(Ksiazka.class, editedBook.id);

            em.getTransaction().begin();
            foundBook.setTytul( editedBook.tytul);
            foundBook.setImie_autor( editedBook.imie_autor);
            foundBook.setNazwisko_autor( editedBook.nazwisko_autor);
            foundBook.setCena( editedBook.cena);
            foundBook.setRok_wydania( editedBook.rok_wydania);
            em.getTransaction().commit();
            getAllBooks();
            return "books";
        }  catch(Exception e) {
            em.getTransaction().rollback();
            System.err.println("Error when trying to update data in database: " + e);
            return "";
        }
    }

    public String editBook(Ksiazka k){
        editedBook=k;
        return "edit";
    }

}

