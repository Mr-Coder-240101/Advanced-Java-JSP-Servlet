package ml;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {

            String username = request.getParameter("username");
            String password = request.getParameter("password");

            String urlJDBC = constants.Constants.JDBC_URL;
            String usernameJDBC = constants.Constants.JDBC_USERNAME;
            String passwordJDBC = constants.Constants.JDBC_PASSWORD;
            String query = "select * from login_credentials where username = '" + username + "';";

            Class.forName("com.mysql.jdbc.Driver");
            try (PrintWriter out = response.getWriter(); Connection connection = DriverManager.getConnection(urlJDBC, usernameJDBC, passwordJDBC); Statement statement = connection.createStatement()) {

                ResultSet result = statement.executeQuery(query);

                RequestDispatcher dispatcher;

                if (result.next()) {
                    if (password == null ? result.getString("password") == null : password.equals(result.getString("password"))) {
                        dispatcher = request.getRequestDispatcher("success");
                        dispatcher.forward(request, response);
                        out.println("This Message Will Not Shown Because I Have Used Forward");
                    } else {
                        dispatcher = request.getRequestDispatcher("index.html");
                        dispatcher.include(request, response);
                        out.println("Password Do Not Match");
                    }
                } else {
                    dispatcher = request.getRequestDispatcher("index.html");
                    dispatcher.include(request, response);
                    out.println("User Does Not Exist");
                }

            }
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e);
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
