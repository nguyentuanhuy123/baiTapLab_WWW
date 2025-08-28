package iuh.fit.se.servlet;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if ("admin".equals(username) && "admin".equals(password)) {
            HttpSession session = request.getSession();
            session.setAttribute("user", username);
            response.sendRedirect("home");
        } else {
            response.sendRedirect("login.jsp");
        }
    }
}
