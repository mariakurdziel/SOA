package example;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "student")
public class Student implements Serializable {

    private Long id;
    private String imie;
    private String nazwisko;
    private Date dodanieData;

    public Student(){
        super();
    }

    public Student(Long id,String imie, String nazwisko, Date dodanieData){
        this.id=id;
        this.imie=imie;
        this.nazwisko=nazwisko;
        this.dodanieData=dodanieData;


    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id",nullable=false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImie() {
        return imie;
    }

    @Column(name="imie",nullable=false)
    public void setImie(String imie) {
        this.imie = imie;
    }

    @Column(name="nazwisko",nullable=false)
    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="created_at",nullable=false)
    public Date getDodanieData() {
        return dodanieData;
    }

    public void setDodanieData(Date dodanieData) {
        this.dodanieData = dodanieData;
    }
}