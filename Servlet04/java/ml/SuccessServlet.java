package ml;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SuccessServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        Details details = new Details();
        
        details.setFname((String)session.getAttribute("fname"));
        details.setLname((String)session.getAttribute("lname"));
        details.setMobileno(Long.parseLong((String)session.getAttribute("mobileno")));
        details.setEmail((String)session.getAttribute("email"));
        details.setAge(Integer.parseInt((String)session.getAttribute("age")));
        details.setCity((String)session.getAttribute("city"));
        
        session.invalidate();
        
        try (PrintWriter out = response.getWriter()) {
            out.println(details);
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}
