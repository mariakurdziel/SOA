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

@ManagedBean(name="Main")
@RequestScoped
public class Main {

    public void createTabele(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA-Zajecia");
        EntityManager em = factory.createEntityManager();
        try {
        Ksiazka k1=new Ksiazka("978-83-89405-00-5 ","Pan Tadeusz","Adam", "Mickiewicz","35.0","2012");
        Ksiazka k2=new Ksiazka("978-83-900210-1-0", "W pustyni i w puszczy","Henryk","Sienkiewicz","40.0","2006");
        Ksiazka k3=new Ksiazka("978-83-7432-357-4" ,"Romeo i julia","Wiliam"," Szekspir","35.0","1999");
        Ksiazka k4=new Ksiazka("978-83-7456-127-1","Millenium","Stieg"," Larsson","40.0","2010");
        Ksiazka k5=new Ksiazka("978-83-7122-347-6","Pierwszy śnieg","Jo","Nesbo","25.0","2015");
        Ksiazka k6= new Ksiazka("978-12-7232-357-4","Kasacja","Remigiusz ","Mróz","35.0","2013");
        Ksiazka k7=new Ksiazka("932-12-6662-357-4","Harry Potter i Czara Ognia","J.K.","Rowling","45.0","2008");
        Ksiazka k8=new Ksiazka("978-83-7432-123-4","Harry Potter i Komnata Tajemnic","J.K.","Rowling","35.0","2001");
        Ksiazka k9=new Ksiazka("911-22-7432-357-4","Hobbit","J.R.","Tolkien","35.0","2010");
        em.getTransaction().begin();
        k1=em.merge(k1);
        k2=em.merge(k2);
        k3=em.merge(k3);
        k4=em.merge(k4);
        k5=em.merge(k5);
        k6=em.merge(k6);
        k7=em.merge(k7);
        k8=em.merge(k8);
        k9=em.merge(k9);
            em.getTransaction().commit();
            System.out.println("Zapisano w bazie: " + k1);
            System.out.println("Zapisano w bazie: " + k2);
            System.out.println("Zapisano w bazie: " + k3);
        }
        catch(Exception e) {
            System.err.println("Blad przy dodawaniu rekordu: " + e);
        }

    }
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