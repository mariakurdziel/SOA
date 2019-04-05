import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.ArrayList;
import java.util.Arrays;

@ManagedBean(name="Ankieta")
@RequestScoped
public class Ankieta {

    public String age;
    public String name;
    public String email;
    public String sex;
    public String new_client;
    public static boolean rendered1;
    public static boolean rendered2;
    public String obwod_biustu;
    public String education;
    public String breast;
    public String cup;
    public String waist;
    public String hips;
    public String ribcage;
    public String belt;
    public String height;
    public String amount;
    public String freq;
    public String color;
    public String clothes;
    public static boolean clientInf;
    public ArrayList<String> sex_type = new ArrayList<String>(Arrays.asList("kobieta","mężczyzna"));
    public ArrayList<String> client = new ArrayList<String>(Arrays.asList("tak","nie"));
    public ArrayList<String> education_levels = new ArrayList<String>(Arrays.asList("podstawowe","średnie","wyższe"));
    public ArrayList<String> cost = new ArrayList<String>(Arrays.asList("do 100 zł", "100-500 zł", "500-1000 zł", "powyżej 1000 zł"));
    public ArrayList<String> frequency=new ArrayList<String>(Arrays.asList("Codziennie", "Raz w tygodniu", "Raz w miesiącu", "Kilka razy w roku"));
    public ArrayList<String> colors = new ArrayList<String>(Arrays.asList("Kolorowojaskrawych", "Stonowanych w szarościach", "W czerni i bieli", "W samej czerni"));
    public ArrayList<String> women = new ArrayList<String>(Arrays.asList("garsonki", "bluzki", "spódniczki", "spodnie"));
    public ArrayList<String> men = new ArrayList<String>(Arrays.asList("spodnie","spodenki", "garnitury", "koszule", "krawaty"));

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public static int counter;

    public ArrayList<String> getAds() {
        return ads;
    }

    public void setAds(ArrayList<String> ads) {
        this.ads = ads;
    }

    public ArrayList<String> ads = new ArrayList<String>(Arrays.asList("biedronka.jpg", "ccc.jpg", "reklama.jpg", "coca.jpg"));

    public void increment(){
        counter++;
    }

    public String generateAdd(){
        int ind=(int)(Math.random() * 4 + 1);

        return ads.get(ind-1);
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getFreq() {
        return freq;
    }

    public void setFreq(String freq) {
        this.freq = freq;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getClothes() {
        return clothes;
    }

    public void setClothes(String clothes) {
        this.clothes = clothes;
    }

    public ArrayList<String> getWomen() {
        return women;
    }

    public void setWomen(ArrayList<String> women) {
        this.women = women;
    }

    public ArrayList<String> getMen() {
        return men;
    }

    public void setMen(ArrayList<String> men) {
        this.men = men;
    }


    public ArrayList<String> getFrequency() {
        return frequency;
    }

    public void setFrequency(ArrayList<String> frequency) {
        this.frequency = frequency;
    }
    public ArrayList<String> getColors() {
        return colors;
    }

    public void setColors(ArrayList<String> colors) {
        this.colors = colors;
    }
    public ArrayList<String> getCost() {
        return cost;
    }

    public void setCost(ArrayList<String> cost) {
        this.cost = cost;
    }

    public boolean isClientInf() {
        return clientInf;
    }

    public void setClientInf(boolean clientInf) {
        this.clientInf = clientInf;
    }
    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getBelt() {
        return belt;
    }

    public void setBelt(String belt) {
        this.belt = belt;
    }

    public void setRendered1(boolean rendered1) {
        this.rendered1 = rendered1;
    }

    public String getRibcage() {
        return ribcage;
    }

    public void setRibcage(String ribcage) {
        this.ribcage = ribcage;
    }

    public String getNew_client() {
        return new_client;
    }

    public void setNew_client(String new_client) {
        this.new_client = new_client;
    }

    public boolean isRendered1() {
        return rendered1;
    }

    public ArrayList<String> getClient() {
        return client;
    }

    public void setClient(ArrayList<String> client) {
        this.client = client;
    }
    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public ArrayList<String> getEducation_levels() {
        return education_levels;
    }

    public void setEducation_levels(ArrayList<String> education_levels) {
        this.education_levels = education_levels;
    }

    public String getObwod_biustu() {
        return obwod_biustu;
    }

    public void setObwod_biustu(String obwod_biustu) {
        this.obwod_biustu = obwod_biustu;
    }


    public boolean isRendered2() {
        return rendered2;
    }

    public void setRendered2(boolean rendered2) {
        this.rendered2 = rendered2;
    }


    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public ArrayList<String> getSex_type() {
        return sex_type;
    }

    public void setSex_type(ArrayList<String> sex_type) {
        this.sex_type = sex_type;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getBreast() {
        return breast;
    }

    public void setBreast(String breast) {
        this.breast = breast;
    }

    public String getCup() {
        return cup;
    }

    public void setCup(String cup) {
        this.cup = cup;
    }

    public String getWaist() {
        return waist;
    }

    public void setWaist(String waist) {
        this.waist = waist;
    }

    public String getHips() {
        return hips;
    }

    public void setHips(String hips) {
        this.hips = hips;
    }
    public void initializeSpecified(){
        if(sex.equals("kobieta")) {
            rendered1 = true;
            rendered2 = false;
        }
        else
        {
            rendered1 = false;
            rendered2 = true;
        }

    }
   public void clientInfo(){
        if(new_client.equals("tak"))
            clientInf =true;
        else
            clientInf =false;
   }

   public String podsumowanie(){
        return "final";
   }
}
