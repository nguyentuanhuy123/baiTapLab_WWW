package iuh.fit.se.bai01.servlets;

import iuh.fit.se.bai01.daos.UserDaoImpl;
import iuh.fit.se.bai01.daos.service.UserDao;
import iuh.fit.se.bai01.entites.User;
import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.sql.DataSource;
import java.io.IOException;
@WebServlet("/register")
public class UserRegistrationServlet extends HttpServlet {
    @Resource(name = "jdbc/users")
    private DataSource dataSource;

    private UserDao userDAO;

    @Override
    public void init() throws ServletException {
        userDAO = new UserDaoImpl(dataSource);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fName = req.getParameter("firstName");
        String lName = req.getParameter("lastName");
        String email = req.getParameter("email");
        String pass = req.getParameter("password");
        String gender=req.getParameter("gender");
        String day=req.getParameter("day");
        String month=req.getParameter("month");
        String year=req.getParameter("year");
        String birthday=day+"/"+month+"/"+year;

        User user = new User(fName, lName, email,pass,birthday,gender);


        userDAO.add(user);

        req.setAttribute("users", userDAO.findAll());
        req.setAttribute("message", "Đăng ký thành công!");
        req.getRequestDispatcher("/views/users.jsp").forward(req, resp);


    }
}
