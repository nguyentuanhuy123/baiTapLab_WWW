package iuh.fit.se.nguyentuanhuy_22699431_lab01servelet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "RegisterServlet",value = "/register-servlet")
public class RegisterServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException,
            IOException {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        String name=request.getParameter("name");
        String email=request.getParameter("email");
        String facebook=request.getParameter("facebook");
        String shortBio=request.getParameter("shortBio");
        String html="<br>"
                + "<head>"
                + "<html>"
                + "<title>Result Page</title>" + "<body>"
                + "</body>"
        + "</html>";
        out.println(html);
    }
    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();

        // Lấy dữ liệu
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String facebook = request.getParameter("facebook");
        String shortBio = request.getParameter("shortBio");

        // Hiển thị thông tin
        out.println("<!DOCTYPE html><html><head><title>Result Page</title></head><body>");
        out.println("<h2>Registration Result</h2>");
        out.println("<p>Name: " + firstName + " " + lastName + "</p>");
        out.println("<p>Email: " + email + "</p>");
        out.println("<p>Facebook: " + facebook + "</p>");
        out.println("<p>Short Bio: " + shortBio + "</p>");
        out.println("</body></html>");
    }
}
