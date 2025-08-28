package iuh.fit.se.servlets;

import com.google.gson.Gson;
import iuh.fit.se.models.User;
import iuh.fit.se.services.UserService;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/users")
public class UserServlet extends HttpServlet {
    @Inject
    private UserService userService;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        List<User> users = userService.getAllUsers();
        Gson gson = new Gson();
        String json = gson.toJson(users);
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();
        out.print(json);
        out.flush();
    }
}
