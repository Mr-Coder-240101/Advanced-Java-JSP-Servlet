package ml;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SuccessServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Cookie cookies[] = request.getCookies();
        Details details = new Details();
        
        for(Cookie cookie: cookies) {
            switch (cookie.getName()) {
                case "fname":
                    details.setFname(cookie.getValue());
                    break;
                case "lname":
                    details.setLname(cookie.getValue());
                    break;
                case "mobileno":
                    details.setMobileno(Long.parseLong(cookie.getValue()));
                    break;
                case "email":
                    details.setEmail(cookie.getValue());
                    break;
                case "age":
                    details.setAge(Integer.parseInt(cookie.getValue()));
                    break;
                case "city":
                    details.setCity(cookie.getValue());
                    break;
                default:
                    
            }
        }
        
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
