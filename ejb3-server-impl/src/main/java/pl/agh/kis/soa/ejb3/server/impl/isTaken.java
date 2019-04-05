package pl.agh.kis.soa.ejb3.server.impl;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import java.util.ArrayList;

@Stateless
@LocalBean
    public class isTaken {

    public boolean isAvailable(String type){
        Manager mng=new Manager();
        for (Seat s:mng.getSeatList()) {
            if(s.getTyp().equals(type) && s.isZajete()==false){
                return true;
            }
        }
        return false;
    }
}
