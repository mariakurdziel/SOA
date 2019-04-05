package pl.agh.kis.soa.ejb3.server.impl;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import java.util.ArrayList;

@Stateful
@LocalBean
public class Transaction {


    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }



    private String surname;
    private String number;
    private String typ;


    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        Transaction.money = money;
    }

    private static double money;
    public ArrayList<Seat> getOrder() {
        return order;
    }

    public void setOrder(ArrayList<Seat> order) {
        this.order = order;
    }

    private static ArrayList<Seat> order=new ArrayList<Seat>();

    public boolean checkMoney(String type){
        if((new Manager()).getSeatPrice(type)<=money) {
            return true;
        }
        else
        return false;
    }

    public void addTicket(String type, double amount){
        this.money=amount;
        Manager mng=new Manager();
        money-=amount;
        order.add(mng.buyTicket(type));
        }

        public void removeTickets(){
            for (Seat s:order) {
                if(s.isRemoved()==true)
                {
                    order.remove(s);
                    money+=s.getCena();

                }
            }
        }
    public void removeAllTickets(){
        order.clear();
    }

    public double countSum(){
        double sum=0.0;
        for (Seat s: order) {
            sum+=s.getCena();
        }
        return sum;
    }


}
