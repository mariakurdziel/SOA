import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import java.util.*;

import static com.sun.org.apache.xml.internal.security.keys.keyresolver.KeyResolver.iterator;

@ManagedBean(name="SamochodyForm")
@ViewScoped
public class SamochodyForm {

    public String brand;
    public String model;
    public String engine;
    public String dcena;
    public String gcena;
    public boolean disable=false;

    public boolean isDisable() {
        return disable;
    }

    public void setDisable(boolean disable) {
        this.disable = disable;
    }


    public String name;
    public String number;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }


    public ArrayList <Samochod> allCars=new ArrayList<Samochod>(Arrays.asList(
            new Samochod("Ford","Mondeo","40000","benzyna"),
            new Samochod("Ford","Mondeo","10000","benzyna"),
            new Samochod("Ford","Focus","35000","benzyna"),
            new Samochod("Ford","Focus","17000","benzyna"),
            new Samochod("Ford","Fiesta","10000","ON"),
            new Samochod("Ford","Mustang","50000","ON"),
            new Samochod("Opel","Corsa","20000","benzyna"),
            new Samochod("Opel","Astra","16000","benzyna"),
            new Samochod("Opel","Meriva","12000","ON"),
            new Samochod("Nissan","Leaf","50000","ON"),
            new Samochod("Nissan","Mo","40000","benzyna")));

    public ArrayList <Samochod> finalList=new ArrayList();
    Set<String> specifiedList = new HashSet<String>();
    public ArrayList <String> brands;
    public ArrayList <String> engineType=new ArrayList<String>(Arrays.asList("ON","benzyna"));

    public ArrayList<String> getEngineType() {
        return engineType;
    }

    public Set<String> getSpecifiedList() {
        return specifiedList;
    }

    public void setSpecifiedList(Set<String> specifiedList) {
        this.specifiedList = specifiedList;
    }
    public void setEngineType(ArrayList<String> engineType) {
        this.engineType = engineType;
    }

    public String getDcena() {
        return dcena;
    }

    public void setDcena(String dcena) {
        this.dcena = dcena;
    }

    public String getGcena() {
        return gcena;
    }

    public void setGcena(String gcena) {
        this.gcena = gcena;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public ArrayList<String> getBrands() {
        return brands;
    }

    public void setBrands(ArrayList<String> brands) {
        this.brands = brands;
    }


    public SamochodyForm(){
        Set<String> x = new HashSet<String>();

        for(int i=0; i<allCars.size();i++) {
            x.add(allCars.get(i).marka);
        }

        brands=new ArrayList(x);
    }



    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public ArrayList<Samochod> getAllCars() {
        return allCars;
    }

    public void setAllCars(ArrayList<Samochod> allCars) {
        this.allCars = allCars;
    }



    public ArrayList<Samochod> getFinalList() {
        return finalList;
    }

    public void setFinalList(ArrayList<Samochod> finalList) {
        this.finalList = finalList;
    }

    public void initializeSpecified() {
        specifiedList.clear();
        for (int i = 0; i < allCars.size(); i++) {
            if (allCars.get(i).marka.equals(brand)) {
                specifiedList.add(allCars.get(i).model);
            }
        }
    }
    public void checkValue(AjaxBehaviorEvent event)
    {
        if(name == null || name.equals("")||number == null || number.equals("")||dcena == null || dcena.equals("")||gcena == null || gcena.equals(""))
            this.disable=true;
        else
            this.disable=false;
    }


    public void initializeFinal(){
        finalList.clear();
        for(int i=0; i<allCars.size();i++){
            if(allCars.get(i).marka.equals(brand) &&allCars.get(i).model.equals(model)&& allCars.get(i).silnik.equals(engine) && Double.parseDouble(allCars.get(i).cena)>=Double.parseDouble(dcena) && Double.parseDouble(allCars.get(i).cena)<=Double.parseDouble(gcena))
                finalList.add(allCars.get(i));
        }
    }

}
