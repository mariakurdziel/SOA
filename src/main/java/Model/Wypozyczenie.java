package Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;

@Entity
@Table(name = "wypozyczenie")
public class Wypozyczenie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Id_wypozyczenia",nullable=false)
    private Long id;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "Id_ksiazki")
    private Ksiazka ksiazka;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "Id_czytelnika")
    private Czytelnik czytelnik;

    @Column(name="Data_wypozyczenia",nullable=false)
    private Date wypozyczenie;

    @Column(name="Data_oddania",nullable=false)
    private Date oddania;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Ksiazka getKsiazka() {
        return ksiazka;
    }

    public void setKsiazka(Ksiazka ksiazka) {
        this.ksiazka = ksiazka;
    }

    public Czytelnik getCzytelnik() {
        return czytelnik;
    }

    public void setCzytelnik(Czytelnik czytelnik) {
        this.czytelnik = czytelnik;
    }

    public Date getWypozyczenie() {
        return wypozyczenie;
    }

    public void setWypozyczenie(Date wypozyczenie) {
        this.wypozyczenie = wypozyczenie;
    }

    public Date getOddania() {
        return oddania;
    }

    public void setOddania(Date oddania) {
        this.oddania = oddania;
    }

    public Wypozyczenie(Czytelnik c, Ksiazka k, Date w, Date o){
        this.czytelnik=c;
        this.ksiazka=k;
        this.oddania=o;
        this.wypozyczenie=w;
    }

    public Wypozyczenie(){}
}
