package example;

import example.Student;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Date;

@ManagedBean(name="example.Main")
@RequestScoped
public class Main {


    public void createTable() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA-Zajecia");
        EntityManager em = factory.createEntityManager();
        try {
            Student s1 = new Student((long) 1,"adam", "nowak",new Date());
            Student s2 = new Student((long) 2,"marek", "kowalski", new Date());
            Student s3 = new Student((long) 3,"anna", "marchewka", new Date());
            em.getTransaction().begin();
            s1=em.merge(s1);
            s2=em.merge(s2);
            s3=em.merge(s3);
            em.getTransaction().commit();
            System.out.println("Zapisano w bazie: " + s1);
            System.out.println("Zapisano w bazie: " + s2);
            System.out.println("Zapisano w bazie: " + s3);
        }
        catch(Exception e) {
            System.err.println("Blad przy dodawaniu rekordu: " + e);
        }
    }

    public void getRecords(){

    }
}