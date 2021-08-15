package ml;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet02 extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            ServletConfig servletConfig =  getServletConfig();
            String servletSecret = servletConfig.getInitParameter("servlet-secret");
            ServletContext servletContext = getServletContext();
            String serverSecret = servletContext.getInitParameter("server-secret");
            out.println("<title>Servlet Servlet02</title>");            
            out.println("<h1>Servlet Servlet02</h1>");
            out.println("<br/>");
            out.println("<h1>Servlet Config : </h1>");
            out.println("<br/>");
            out.println("Servlet Secret : " + servletSecret);
            out.println("<h1>Servlet Context : </h1>");
            out.println("<br/>");
            out.println("Server Secret : " + serverSecret);
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
