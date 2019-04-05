package pl.agh.kis.soa.ejb3.server.impl;

import javax.ejb.LocalBean;
import javax.ejb.Lock;
import javax.ejb.Singleton;
import java.util.*;

@Singleton
@LocalBean
public class Manager {

    public void setSeats(ArrayList<Seat> seats) {
        this.seats = seats;
    }

    private static ArrayList<Seat> seats=new ArrayList<Seat>(Arrays.asList(new Seat("1",200.0,"Lożą",false),
            new Seat("2",200.0,"Loża",false),
            new Seat("3",200.0,"1 rząd",false),
            new Seat("4",200.0,"1 rząd",false),
            new Seat("5",150.0,"2 rząd",false),
            new Seat("6",150.0,"2 rząd",false),
            new Seat("7",150.0,"3 rząd",false),
            new Seat("8",150.0,"3 rząd",false),
            new Seat("9",100.0,"4 rząd",false),
            new Seat("10",100.0,"4 rząd",false)));


    public ArrayList<String> getTypes() {
        return types;
    }

    public ArrayList<String> types=new ArrayList<String>(Arrays.asList("Loża","1 rząd","2 rząd","3 rząd","4 rząd"));

    public Map<String, Double> getCennik() {
        return cennik;
    }

    public void setCennik(Map<String, Double> cennik) {
        this.cennik = cennik;
    }

    public Map<String, Double> cennik = new HashMap<String,Double>() {{
        put("Loża", 200.0);
        put("1 rząd", 200.0);
        put("2 rząd", 150.0);
        put("3 rząd", 150.0);
        put("4 rząd", 100.0);
    }};


    @Lock
    public ArrayList<Seat> getSeatList(){
        return seats;
    }

    @Lock
    public double getSeatPrice(String type){

        return cennik.get(type);
    }
    @Lock
    public Seat buyTicket(String type){
        for (Seat s:seats) {
            if(s.getTyp().equals(type) && s.isZajete()==false){
                s.setZajete(true);
                return s;
            }
        }
        return null;
    }

}
