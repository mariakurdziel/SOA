import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

@WebServlet(name = "isNumber")
public class isNumber extends HttpServlet {

    public boolean isNum(String number){
       try {
           Double.parseDouble(number);
           return true;
       }
     catch(NumberFormatException e){
        return false;
    }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("windows-1250");
        PrintWriter out = response.getWriter();
        Enumeration<String> names = request.getParameterNames();
        ArrayList<Double> nums=new ArrayList<>();
        boolean flag=true;

        while (names.hasMoreElements()) {
            String it = request.getParameter(names.nextElement());
            if(!isNum(it)){
                flag=false;
                break;
            }
            nums.add(Double.parseDouble(it));
        }
        out.println("<html>");
        out.println("<head><title>Pierwszy WalidacjaDanych</title></head>");
        out.println("<body>");

        if(flag){
            Collections.sort(nums);
            out.println("<p>Liczby w kolejności:</p>");
            for(Double d: nums)
            {
                out.println("<p>"+d+"</p>");
            }
        }
        else
            out.println("Nie wszystkie podane argumenty są liczbami!");

        out.println("</body>");
        out.println("</html>");
        out.close();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
