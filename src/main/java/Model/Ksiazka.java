package Model;

import Model.Autor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ksiazka")
public class Ksiazka {

    private static Long licznik=(long)0;

    @Id
    @Column(name="Id_ksiazki",nullable=false)
    private Long id;

    @Column(name="tytul",nullable=false)
    private String tytul;

    @ManyToOne(targetEntity = Autor.class,cascade=CascadeType.ALL)
    @JoinColumn(name = "Id_autora")
    private Autor autor;

    @OneToMany(mappedBy = "ksiazka",cascade=CascadeType.ALL)
    private List<Wypozyczenie> wypozyczenia;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTytul() {
        return tytul;
    }

    public void setTytul(String tytul) {
        this.tytul = tytul;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public List<Wypozyczenie> getWypozyczenia() {
        return wypozyczenia;
    }

    public void setWypozyczenia(List<Wypozyczenie> wypozyczenia) {
        this.wypozyczenia = wypozyczenia;
    }


    public Ksiazka(String tytul, Autor autor){
        this.tytul=tytul;
        this.autor=autor;
        licznik++;
        this.id=licznik;
    }

    public Ksiazka(){}
}
