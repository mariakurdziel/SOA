import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;

@ManagedBean(name="FiltrKsiazek")
@RequestScoped
public class FiltrKsiazek {


    public String type;
    public String gcena;
    public String dcena;
    public String currency;
    public ArrayList<String> currencies = new ArrayList<String>(Arrays.asList("PLN","USD","EUR"));
    public ArrayList<String> types=new ArrayList<String>(Arrays.asList("klasyka literatury","kryminał","fantastyka"));
    public static ArrayList<Ksiazka> ordered=new ArrayList<Ksiazka>();
    public  static ArrayList<Ksiazka> books=new ArrayList<Ksiazka>(Arrays.asList(
            new Ksiazka("Pan Tadeusz","Adam Mickiewicz","klasyka literatury","35.0","PLN","700"),
            new Ksiazka("W pustyni i w puszczy","Henryk Sienkiewicz","klasyka literatury","40.0","PLN","500"),
            new Ksiazka("Romeo i julia","Wiliam Szekspir","klasyka literatury","35.0","PLN","700"),
            new Ksiazka("Millenium","Stieg Larsson","kryminał","40.0","PLN","600"),
            new Ksiazka("Pierwszy śnieg","Jo Nesbo","kryminał","25.0","PLN","350"),
            new Ksiazka("Kasacja","Remigiusz Mróz","kryminał","35.0","PLN","400"),
            new Ksiazka("Harry Potter i Czara Ognia","J.K.Rowling","fantastyka","45.0","PLN","650"),
            new Ksiazka("Harry Potter i Komnata Tajemnic","J.K.Rowling","fantastyka","35.0","PLN","350"),
            new Ksiazka("Hobbit","J.R.Tolkien","fantastyka","35.0","PLN","400")

    ));




    public ArrayList<Ksiazka> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<Ksiazka> books) {
        this.books = books;
    }

    public ArrayList<Ksiazka> getOrdered() {
        return ordered;
    }

    public void setOrdered(ArrayList<Ksiazka> ordered) {
        this.ordered = ordered;
    }


    public ArrayList<String> getTypes() {
        return types;
    }

    public void setTypes(ArrayList<String> types) {
        this.types = types;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getGcena() {
        return gcena;
    }

    public void setGcena(String gcena) {
        this.gcena = gcena;
    }

    public String getDcena() {
        return dcena;
    }

    public void setDcena(String dcena) {
        this.dcena = dcena;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String val) {
        this.currency = val;
    }

    public ArrayList<String> getCurrencies() {
        return currencies;
    }

    public void setCurrencies(ArrayList<String> currencies) {
        this.currencies = currencies;
    }

    public void initialize(){
        books=new ArrayList<Ksiazka>(Arrays.asList(
                new Ksiazka("Pan Tadeusz","Adam Mickiewicz","klasyka literatury","35.0","PLN","700"),
                new Ksiazka("W pustyni i w puszczy","Henryk Sienkiewicz","klasyka literatury","40.0","PLN","500"),
                new Ksiazka("Romeo i julia","Wiliam Szekspir","klasyka literatury","35.0","PLN","700"),
                new Ksiazka("Millenium","Stieg Larsson","kryminał","40.0","PLN","600"),
                new Ksiazka("Pierwszy śnieg","Jo Nesbo","kryminał","25.0","PLN","350"),
                new Ksiazka("Kasacja","Remigiusz Mróz","kryminał","35.0","PLN","400"),
                new Ksiazka("Harry Potter i Czara Ognia","J.K.Rowling","fantastyka","45.0","PLN","650"),
                new Ksiazka("Harry Potter i Komnata Tajemnic","J.K.Rowling","fantastyka","35.0","PLN","350"),
                new Ksiazka("Hobbit","J.R.Tolkien","fantastyka","35.0","PLN","400")

        ));

    }


    public void filtruj() throws IOException {

        ArrayList<Ksiazka> tmp=new ArrayList<Ksiazka>();
        NBPConnector x=new NBPConnector();
        String cost;
        int ind;

        for (Ksiazka k:books) {
            if(!k.typ.equals(type) || !(Double.parseDouble(k.cena)>=Double.parseDouble(dcena)) ||!( Double.parseDouble(k.cena)<=Double.parseDouble(gcena))){
                tmp.add(k);
            }
            else {
                cost = x.convertValue("PLN", currency, k.cena);
                ind=cost.indexOf('.');
                k.cena=cost.substring(0,ind+2);
                k.waluta=currency;
            }
        }
        books.removeAll(tmp);
    }
    public void ukryj() throws IOException {
        ArrayList<Ksiazka> tmp=new ArrayList<Ksiazka>();
        NBPConnector x=new NBPConnector();
        String cost;
        int ind;

        for (Ksiazka k:books) {
            if(k.typ.equals(type)&& Double.parseDouble(k.cena)>=Double.parseDouble(dcena) && Double.parseDouble(k.cena)<=Double.parseDouble(gcena)){
               tmp.add(k);
            }
            else {
                cost = x.convertValue("PLN", currency, k.cena);
                ind=cost.indexOf('.');
                k.cena=cost.substring(0,ind+2);
                k.waluta=currency;
            }
        }
        books.removeAll(tmp);
    }

    public void addBook(Ksiazka book){
       ordered.add(book);

    }

    public String redirect(){
        return "order";
    }


    public String countOrder(){
        Double x=0.0;
        String suma;
        int ind;
        for (Ksiazka k:ordered) {
            x+=Double.parseDouble(k.cena);
        }
        suma=Double.toString(x);
        ind=suma.indexOf('.');

     return suma.substring(0,ind+2);
    }
}
