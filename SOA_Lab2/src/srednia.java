import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "srednia")
public class srednia extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("windows-1250");
        PrintWriter out = response.getWriter();
        double num1 = Double.parseDouble(request.getParameter("pierwsza"));
        double num2 = Double.parseDouble(request.getParameter("druga"));
        double num3 = Double.parseDouble(request.getParameter("trzecia"));
        double num4 = Double.parseDouble(request.getParameter("czwarta"));
        double num5 = Double.parseDouble(request.getParameter("piata"));
        double srednia=(num1+num2+num3+num4+num5)/5;
        out.println("<html>");
        out.println("<head><title>Pierwszy WalidacjaDanych</title></head>");
        out.println("<body>");
        out.println("<p>Srednia z podanych liczb: "+srednia+"</p>");
        out.println("</body>");
        out.println("</html>");
        out.close();

    }
}
