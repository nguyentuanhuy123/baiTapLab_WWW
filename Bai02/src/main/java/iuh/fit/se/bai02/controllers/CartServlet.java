package iuh.fit.se.bai02.controllers;

import iuh.fit.se.bai02.daos.ProductDaoImpl;
import iuh.fit.se.bai02.daos.service.ProductDao;
import iuh.fit.se.bai02.models.ItemCart;
import jakarta.annotation.Resource;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
@WebServlet(name = "CartServlet", urlPatterns = {"/cart", "/cart*"})
public class CartServlet extends HttpServlet {
    @Resource(name = "jdbc/shopping")
    private DataSource dataSource;

    private ProductDao productDAO;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        this.productDAO = new ProductDaoImpl(dataSource);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // delegate to doPost for actions or show
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        if (action == null) action = "";

        switch (action) {
            case "buy":
                handleAddToCart(req, resp);
                break;
            case "update":
                handleUpdateCart(req, resp);
                break;
            case "remove":
                handleRemoveFromCart(req, resp);
                break;
            case "checkout":
                handleCheckout(req, resp);
                break;
            default:
                // show cart page
                handleShowCart(req, resp);
                break;
        }
    }
    private void handleCheckout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session != null) {
            session.removeAttribute("cart");
        }
        req.setAttribute("checkoutSuccess", true);
        req.getRequestDispatcher("/views/cart.jsp").forward(req, resp);
    }

    private void handleShowCart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/cart.jsp").forward(req, resp);
    }

    private void handleAddToCart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        int quantity = parseQuantity(req.getParameter("quantity"), 1);

        HttpSession session = req.getSession(true);
        List<ItemCart> cart = (List<ItemCart>) session.getAttribute("cart");
        if (cart == null) {
            cart = new ArrayList<>();
        }

        int index = findProductIndex(id, cart);
        if (index == -1) {
            var product = productDAO.getById(id);
            if (product != null) {
                cart.add(new ItemCart(product, quantity));
            }
        } else {
            ItemCart item = cart.get(index);
            item.setQuantity(item.getQuantity() + quantity);
        }

        session.setAttribute("cart", cart);
        resp.sendRedirect(req.getContextPath() + "/cart");
    }

    private void handleUpdateCart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        int quantity = parseQuantity(req.getParameter("quantity"), 1);

        HttpSession session = req.getSession(false);
        if (session == null) {
            resp.sendRedirect(req.getContextPath() + "/cart");
            return;
        }
        List<ItemCart> cart = (List<ItemCart>) session.getAttribute("cart");
        if (cart == null) {
            resp.sendRedirect(req.getContextPath() + "/cart");
            return;
        }

        int index = findProductIndex(id, cart);
        if (index != -1) {
            if (quantity <= 0) {
                cart.remove(index);
            } else {
                cart.get(index).setQuantity(quantity);
            }
            session.setAttribute("cart", cart);
        }

        resp.sendRedirect(req.getContextPath() + "/cart");
    }

    private void handleRemoveFromCart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");

        HttpSession session = req.getSession(false);
        if (session != null) {
            List<ItemCart> cart = (List<ItemCart>) session.getAttribute("cart");
            if (cart != null) {
                int index = findProductIndex(id, cart);
                if (index != -1) cart.remove(index);
                session.setAttribute("cart", cart);
            }
        }
        resp.sendRedirect(req.getContextPath() + "/cart");
    }

    private int findProductIndex(String id, List<ItemCart> cart) {
        if (id == null || cart == null) return -1;
        for (int i = 0; i < cart.size(); i++) {
            String pid = cart.get(i).getProduct().getId();
            if (pid != null && pid.equals(id)) {
                return i;
            }
        }
        return -1;
    }

    private int parseQuantity(String q, int defaultValue) {
        if (q == null) return defaultValue;
        try {
            return Integer.parseInt(q);
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }

}
