import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name="Zad1")
@RequestScoped
public class Zad1 {
    static int losuj;

    public int getCount1() {
        return count1;
    }

    public int getCount2() {
        return count2;
    }

    public int getCount3() {
        return count3;
    }


    public int getCount4() {
        return count4;
    }

    public int getCount5() {
        return count5;
    }

    public int getTrafiony() {
        return trafiony;
    }


    public static int count1;
    public static int count2;
    public static int count3;
    public static int count4;
    public static int count5;
    public static int trafiony;

    public static int getLosuj() {
        return losuj;
    }

    public static void setLosuj(int losuj) {
        Zad1.losuj = losuj;
    }
    public int losujnumer(){
        this.losuj = (int)(Math.random() * 5 + 1); return losuj;
    }

    public String redirect1() {
        if (losuj==1) {
            trafiony++;
            return "trafiony";
        }
        else {
            count1++;
            return "page1";
        }
    }
    public String redirect2() {
        if (losuj==2) {
            trafiony++;
            return "trafiony";
        }
        else {
            count2++;
            return "page2";
        }
    }

    public String redirect3() {
        if (losuj==3) {
            trafiony++;
            return "trafiony";
        }
        else {
            count3++;
            return "page3";
        }
    }

    public String redirect4() {
        if (losuj==4) {
            trafiony++;
            return "trafiony";
        }
        else {
            count4++;
            return "page4";
        }
    }
    public String redirect5() {
        if (losuj==5) {
            trafiony++;
            return "trafiony";
        }
        else {
            count5++;
            return "page5";
        }
    }

}
