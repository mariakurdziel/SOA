import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name="Ksiazka")
@RequestScoped
public class Ksiazka {


    public String tytul;
    public String autor;
    public String typ;
    public String cena;
    public String waluta;
    public String strony;


    public Ksiazka(String tytul, String autor, String typ, String cena, String waluta, String strony){
        this.tytul=tytul;
        this.autor=autor;
        this.typ=typ;
        this.cena=cena;
        this.waluta=waluta;
        this.strony=strony;
    }
    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    public String getCena() {
        return cena;
    }

    public void setCena(String cena) {
        this.cena = cena;
    }

    public String getWaluta() {
        return waluta;
    }

    public void setWaluta(String waluta) {
        this.waluta = waluta;
    }

    public String getStrony() {
        return strony;
    }

    public void setStrony(String strony) {
        this.strony = strony;
    }

    public String getTytul() {
        return tytul;
    }

    public void setTytul(String tytul) {
        this.tytul = tytul;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }



}
