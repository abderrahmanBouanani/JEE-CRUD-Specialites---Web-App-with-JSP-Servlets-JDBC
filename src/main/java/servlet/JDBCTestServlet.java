package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class JDBCTestServlet extends HttpServlet {
    private final String JDBC_URL =
            "jdbc:mysql://localhost:3306/tp2jee?useSSL=false&serverTimezone=UTC";
    private final String USER = "root"; // à adapter
    private final String PASSWORD = "";
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws
            ServletException, IOException {
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(JDBC_URL, USER,
                    PASSWORD);
            out.println("<h2> Connexion JDBC réussie !</h2>");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM specialite");
            out.println("<ul>");
            while (rs.next()) {
                out.println("<li>" + rs.getString("nom") + " - " + rs.getString("description") +
                        "</li>");
            }
            out.println("</ul>");
            conn.close();
        } catch (Exception e) {
            out.println("<h2>Erreur de connexion JDBC :</h2>");
            out.println("<pre>" + e.getMessage() + "</pre>");
        }
    }
}