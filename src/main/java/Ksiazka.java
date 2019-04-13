import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.*;

@ManagedBean(name="Ksiazka")
@RequestScoped

@Entity
@Table(name = "Books")
public class Ksiazka {


    public String tytul;
    public String imie_autor;
    public String nazwisko_autor;
    public String cena;
    public String ISBN;
    public String rok_wydania;
    public Long id=(long)0;

    public Ksiazka(){}


    public Ksiazka( String ISBN,String tytul,String imie_autor, String nazwisko_autor, String cena, String rok_wydania ){

        this.tytul=tytul;
        this.imie_autor=imie_autor;
        this.nazwisko_autor=nazwisko_autor;
        this.cena=cena;
        this.ISBN=ISBN;
        this.rok_wydania=rok_wydania;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Id",nullable=false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name="IBSN",nullable=false)
    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }


    @Column(name="tytul",nullable=false)
    public String getTytul() {
        return tytul;
    }

    public void setTytul(String tytul) {
        this.tytul = tytul;
    }


    @Column(name="imie",nullable=false)
    public String getImie_autor() {
        return imie_autor;
    }

    public void setImie_autor(String imie_autor) {
        this.imie_autor = imie_autor;
    }


    @Column(name="nazwisko",nullable=false)
    public String getNazwisko_autor() {
        return nazwisko_autor;
    }

    public void setNazwisko_autor(String nazwisko_autor) {
        this.nazwisko_autor = nazwisko_autor;
    }


    @Column(name="cena",nullable=false)
    public String getCena() {
        return cena;
    }

    public void setCena(String cena) {
        this.cena = cena;
    }


    @Column(name="rok",nullable=false)
    public String getRok_wydania() {
        return rok_wydania;
    }

    public void setRok_wydania(String rok_wydania) {
        this.rok_wydania = rok_wydania;
    }

}
