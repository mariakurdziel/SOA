package Ksiega;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Vector;

@WebServlet(name = "DodajWpis")
public class DodajWpis extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletConfig().getInitParameter("sesja");
        Vector<Wpis> previousComments = (Vector<Wpis>) request.getSession().getAttribute("comments");
        if(previousComments!= null){
            previousComments.add(new Wpis(request.getParameter("name"), request.getParameter("mail"), request.getParameter("comment")));
            request.getSession().setAttribute("comments", previousComments);
        } else {
            Vector<Wpis> comments = new Vector<>();
            comments.add(new Wpis(request.getParameter("name"), request.getParameter("mail"), request.getParameter("comment")));
            request.getSession().setAttribute("comments", comments);
        }

        response.sendRedirect("ksiegaGosci.jsp");

    }
}
