package iuh.fit.se.bai02.controllers;

import iuh.fit.se.bai02.daos.ProductDaoImpl;
import iuh.fit.se.bai02.daos.service.ProductDao;
import jakarta.annotation.Resource;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.sql.DataSource;
import java.io.IOException;
@WebServlet("/products")
public class ProductServlet extends HttpServlet {

    @Resource(name = "jdbc/shopping")
    private DataSource dataSource;

    private ProductDao productDAO;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        this.productDAO = new ProductDaoImpl(this.dataSource);
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("products", productDAO.findAll());
        req.getRequestDispatcher("views/products.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
