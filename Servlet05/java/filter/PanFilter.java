package filter;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class PanFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {

        String pan = request.getParameter("pan");
        if (pan == null || !pan.matches("[A-Z]{5}[0-9]{4}[A-Z]{1}")) {
            try (PrintWriter out = response.getWriter()) {
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.html");
                requestDispatcher.include(request, response);
                out.println("Invalid PAN Number!");
            }
        } else {
            chain.doFilter(request, response);
        }

    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }

}
