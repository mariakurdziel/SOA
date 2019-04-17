package Controllers;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.ArrayList;
import java.util.Arrays;

@ManagedBean(name="Controller")
@RequestScoped
public class Controller {
    public boolean render1=false;
    public boolean render2=false;
    public boolean render3=false;
    public boolean render4=false;
    public String type;
    public ArrayList<String> data_type = new ArrayList<String>(Arrays.asList("wypożyczenia","czytelnicy","książki", "autorzy"));

    public ArrayList<String> getData_type() {
        return data_type;
    }

    public void setData_type(ArrayList<String> data_type) {
        this.data_type = data_type;
    }

    public boolean isRender1() {
        return render1;
    }

    public void setRender1(boolean render1) {
        this.render1 = render1;
    }

    public boolean isRender2() {
        return render2;
    }

    public void setRender2(boolean render2) {
        this.render2 = render2;
    }

    public boolean isRender3() {
        return render3;
    }

    public void setRender3(boolean render3) {
        this.render3 = render3;
    }

    public boolean isRender4() {
        return render4;
    }

    public void setRender4(boolean render4) {
        this.render4 = render4;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void initializeSpecified(){
        if(type.equals("wypożyczenia")){
            render1=true;
            render2=false;
            render3=false;
            render4=false;
        }
        else if(type.equals("czytelnicy")){
            render1=false;
            render2=true;
            render3=false;
            render4=false;
        }
        else if(type.equals("książki")){
            render1=false;
            render2=false;
            render3=true;
            render4=false;
        }
        else{
            render1=false;
            render2=false;
            render3=false;
            render4=true;
        }
    }
}
