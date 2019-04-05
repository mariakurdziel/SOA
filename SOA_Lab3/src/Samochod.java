import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name="Samochod")
@RequestScoped
public class Samochod {

    public String marka;
    public String model;
    public String cena;
    public String silnik;

    public String getCena() {
        return cena;
    }
    public String getMarka() {
        return marka;
    }

    public String getModel() {
        return model;
    }

    public String getSilnik() {
        return silnik;
    }


    public Samochod(String marka, String model, String cena, String silnik){
        this.marka=marka;
        this.model=model;
        this.cena=cena;
        this.silnik=silnik;
    }


}
