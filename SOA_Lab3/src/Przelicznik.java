import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ManagedBean(name="Przelicznik")
@RequestScoped
public class Przelicznik {



    public String selectedCurrency1;
    public String selectedCurrency2;

    public String getKurs1() {
        return kurs1;
    }

    public void setKurs1(String kurs1) {
        this.kurs1 = kurs1;
    }

    public String kurs1;

    public String getKurs2() {
        return kurs2;
    }

    public void setKurs2(String kurs2) {
        this.kurs2 = kurs2;
    }

    public String kurs2;


    public String getNewCurrencyValue() {
        return newCurrencyValue;
    }

    public void setNewCurrencyValue(String newCurrencyValue) {
        this.newCurrencyValue = newCurrencyValue;
    }


    public String newCurrencyValue;
    public String amount;
    public String value;

    public List getCurrencies() {
        return currencies;
    }

    static ArrayList<String> currencies = new ArrayList<String>(Arrays.asList("EUR","PLN"));

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getSelectedCurrency1() {
        return selectedCurrency1;
    }

    public void setSelectedCurrency1(String selectedCurrency1) {
        this.selectedCurrency1 = selectedCurrency1;
    }

    public String getSelectedCurrency2() {
        return selectedCurrency2;
    }

    public void setSelectedCurrency2(String selectedCurrency2) {
        this.selectedCurrency2 = selectedCurrency2;
    }

    public String redirect(){
        return "addCurrency";
    }

    public String addNewCurrency(){
        currencies.add(newCurrencyValue);
        return "przelicznik";
    }

    public String convertValue() throws IOException {

        if(selectedCurrency1.equals("PLN"))
            kurs1="1.0";
        else
            kurs1 = NBPConnector.exchangeRate(selectedCurrency1);

        if(selectedCurrency2.equals("PLN"))
            kurs2="1.0";
        else
            kurs2=NBPConnector.exchangeRate(selectedCurrency2);

        Double val=((Double.parseDouble(kurs1)/Double.parseDouble(kurs2))*Double.parseDouble(amount));

        this.value=Double.toString(val);
        return "podsumowanie";
    }
}
