package iuh.fit.se.demo;

import iuh.fit.se.models.Student;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/registration-form")
public class RegistrationForm extends HttpServlet {
    public RegistrationForm(){
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String fname=req.getParameter("txtFName");
        String lname=req.getParameter("txtLName");
        String birthday=req.getParameter("birthday");
        String email=req.getParameter("txtEmail");
        String gender=req.getParameter("gender");

        Student sv=new Student();
        sv.setFName(fname);
        sv.setLName(lname);
        sv.setEmail(email);
        sv.setGender(gender);
        sv.setBDay(birthday);

        req.setAttribute("student",sv);

        RequestDispatcher rd = req.getRequestDispatcher("/views/result-form.jsp");
        rd.forward(req,resp);
    }
}
