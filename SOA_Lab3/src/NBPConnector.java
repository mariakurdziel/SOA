import sun.misc.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class NBPConnector {

    public static String exchangeRate(String currency) throws IOException {

        String x="<Mid>";
        String value="";
        String urlString =  "http://api.nbp.pl/api/exchangerates/rates/A/"+currency+"/?format=xml";
        URL url = new URL(urlString);
        URLConnection conn = url.openConnection();
        InputStream is = conn.getInputStream();

        Scanner s = new Scanner(is).useDelimiter("\\A");
        String result = s.hasNext() ? s.next() : "";

        int ind = result.indexOf(x)+x.length();

        while(result.charAt(ind)!='<') {
            value += result.charAt(ind);
            ind++;
        }

     return value;
    }

    public String convertValue(String curr1, String curr2, String cost) throws IOException {
        String kurs1;
        String kurs2;
        String value;

        if(curr1.equals("PLN"))
            kurs1="1.0";
        else
            kurs1 = NBPConnector.exchangeRate(curr2);

        if(curr2.equals("PLN"))
            kurs2="1.0";
        else
            kurs2=NBPConnector.exchangeRate(curr2);

        Double val=((Double.parseDouble(kurs1)/Double.parseDouble(kurs2))*Double.parseDouble(cost));

        value=Double.toString(val);
        return value;
    }

}
