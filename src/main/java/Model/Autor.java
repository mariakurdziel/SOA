package Model;

import javax.persistence.*;
import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "autor")
public class Autor {

    private static Long licznik=(long)0;

    @Id
    @Column(name="Id_autora",nullable=false)
    private Long id_autora;
    @Column(name="Autor")
    private String name;

    @OneToMany(mappedBy = "autor",cascade=CascadeType.ALL)
    private List<Ksiazka> ksiazki;

    public Long getId_autora() {
        return id_autora;
    }

    public void setId_autora(Long id_autora) {
        this.id_autora = id_autora;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Ksiazka> getKsiazki() {
        return ksiazki;
    }

    public void setKsiazki(List<Ksiazka> ksiazki) {
        this.ksiazki = ksiazki;
    }

    public Autor(String name){
        this.name=name;
        licznik++;
        this.id_autora=licznik;
    }

    public Autor(){}
}
