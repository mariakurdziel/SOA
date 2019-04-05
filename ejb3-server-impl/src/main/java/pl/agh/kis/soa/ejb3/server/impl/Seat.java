package pl.agh.kis.soa.ejb3.server.impl;

public class Seat {

    public String getId() {
        return id;
    }

    private String id;

    public String getTyp() {
        return typ;
    }

    private String typ;

    public Double getCena() {
        return cena;
    }

    public void setCena(Double cena) {
        this.cena = cena;
    }

    private Double cena;


    public boolean isZajete() {
        return zajete;
    }

    public void setZajete(boolean zajete) {
        this.zajete = zajete;
    }

    private boolean zajete;


    public boolean isRemoved() {
        return removed;
    }

    public void setRemoved(boolean removed) {
        this.removed = removed;
    }

    private static boolean removed=false;


    public Seat(String id, double cena, String typ, boolean zajete){
        this.id=id;
        this.cena=cena;
        this.typ=typ;
        this.zajete=false;
    }
}