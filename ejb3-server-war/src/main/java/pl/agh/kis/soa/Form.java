package pl.agh.kis.soa;
import pl.agh.kis.soa.ejb3.server.impl.Manager;
import pl.agh.kis.soa.ejb3.server.impl.Seat;
import pl.agh.kis.soa.ejb3.server.impl.Transaction;
import pl.agh.kis.soa.ejb3.server.impl.isTaken;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;

@ManagedBean(name="Form")
@Named
@ViewScoped
public class Form implements Serializable {


    private String name;
    private String surname;
    private String number;
    private String typ;


    public Double getSum() {
        return sum;
    }

    public void setSum(Double sum) {
        this.sum = sum;
    }

    private static double sum=0.0;


    public boolean isPanel() {
        return panel;
    }

    public void setPanel(boolean panel) {
        this.panel = panel;
    }

    private static boolean panel=false;

    public boolean isAvilable() {
        return avilable;
    }

    public void setAvilable(boolean avilable) {
        this.avilable = avilable;
    }

    private boolean avilable=false;

    public boolean isRender() {
        return render;
    }

    public void setRender(boolean render) {
        this.render = render;
    }

    private boolean render=false;

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    private double amount;

    @EJB
    Manager manager;

    @EJB
    isTaken taken;

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    @EJB
    Transaction transaction;


    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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


    public void makeTransaction(){
        transaction.setMoney(amount);
        if(!transaction.checkMoney(typ))
            render=true;
        else if(!taken.isAvailable(typ))
            avilable=true;
        else {
            amount -= manager.getSeatPrice(typ);
            sum+=manager.getSeatPrice(typ);
            transaction.addTicket(typ,amount);
        }
    }

     public ArrayList <Seat> getOrder(){
        return transaction.getOrder();
     }

     public void make_panel(){
        panel=true;
     }


     public void removeTickets(){
        transaction.removeTickets();
        sum-=transaction.getMoney();
        amount=transaction.getMoney();
     }

     public void removeAllTickets(){
        amount+=transaction.countSum();
        sum=0.0;
        transaction.removeAllTickets();

     }

}
