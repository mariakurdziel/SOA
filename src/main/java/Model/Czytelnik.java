package Model;

import Model.Ksiazka;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "czytelnik")
public class Czytelnik {

    private static Long licznik=(long)0;
    @Id
    @Column(name="Id_czytelnika",nullable=false)
    private Long id_czytelnika;
    private String name;
    private String surname;

    @OneToMany(mappedBy = "czytelnik",cascade=CascadeType.ALL)
    private List<Wypozyczenie> wypozyczenia;

    public Long getId_czytelnika() {
        return id_czytelnika;
    }

    public void setId_czytelnika(Long id_czytelnika) {
        this.id_czytelnika = id_czytelnika;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public List<Wypozyczenie> getWypozyczenia() {
        return wypozyczenia;
    }

    public void setWypozyczenia(List<Wypozyczenie> wypozyczenia) {
        this.wypozyczenia = wypozyczenia;
    }

    public Czytelnik(String name, String surname){
        this.name=name;
        this.surname=surname;
        licznik++;
        this.id_czytelnika=licznik;
    }

    public Czytelnik(){}
}
