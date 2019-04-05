package Ksiega;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

@WebServlet(name = "WalidacjaDanych")
public class WalidacjaDanych extends HttpServlet {

    Vector<DaneOsobowe> daneOsobowe = new Vector<>();

    private void addUsers(){
        daneOsobowe.add(new DaneOsobowe("maria","mk7","maria","kurdziel" ));
        daneOsobowe.add(new DaneOsobowe("wojciech","wk1","wojciech","kurdziel" ));
        daneOsobowe.add(new DaneOsobowe("ola","ok2","aleksandra","nowak" ));
        daneOsobowe.add(new DaneOsobowe("andrzej","ak3","andrzej","kowalski" ));

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.addUsers();

             for(int i=0; i<daneOsobowe.size();++i) {
                 if (request.getParameter("imie").equals(daneOsobowe.get(i).login) && request.getParameter("haslo").equals(daneOsobowe.get(i).password)) {
                     try {
                         response.sendRedirect("ksiegaGosci.jsp");

                     } catch (IOException e) {
                         e.printStackTrace();
                     }
                 }
             }

            response.sendRedirect("KsiegaGosciForm.jsp?valid=false");
        }

    }

