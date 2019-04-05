package Piwo;

import java.util.HashMap;

public class EkspertPiwny {
    private static HashMap<String, String> hmap = new HashMap<String, String>(){{put("żółte", "Okocim"); put("brazowe", "Harnaś");put("czarne", "Żywiec");put("czerwone", "Tyskie");}};
    public static String beerColor;

    public static String getColor(){
        return beerColor;
    }

    public static void setColor(String color){
        beerColor=color;
    }

    public static String getBeer(){
        if(hmap.get(beerColor)==null){
            return "Brak propozycji dla danego koloru";
        }
        else
            return hmap.get(beerColor);
    }


}
