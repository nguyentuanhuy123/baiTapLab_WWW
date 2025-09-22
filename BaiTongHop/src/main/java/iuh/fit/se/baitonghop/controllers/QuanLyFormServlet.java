package iuh.fit.se.baitonghop.controllers;

import iuh.fit.se.baitonghop.daos.DienThoaiDAO;
import iuh.fit.se.baitonghop.daos.impls.DienThoaiDAOImpls;
import iuh.fit.se.baitonghop.models.DienThoai;
import iuh.fit.se.baitonghop.utils.EntityManagerFactoryUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/quanly")
public class QuanLyFormServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EntityManager em = EntityManagerFactoryUtil.getEntityManager();
        try {
            DienThoaiDAO dao = new DienThoaiDAOImpls(em);

            String kw = req.getParameter("kw");
            List<DienThoai> dienThoais;
            if (kw != null && !kw.isBlank()) {
                String pattern = "%" + kw.trim() + "%";
                dienThoais = dao.findAll();
            } else {
                dienThoais = dao.findAll();
            }

            req.setAttribute("dienThoais", dienThoais);

            String msg = req.getParameter("msg");
            if (msg != null) {
                if ("deleted".equals(msg)) {
                    req.setAttribute("message", "Xóa bản ghi thành công.");
                } else if ("error".equals(msg)) {
                    req.setAttribute("error", "Đã xảy ra lỗi khi xóa bản ghi.");
                }
            }

            req.getRequestDispatcher("/views/QuanLyForm.jsp").forward(req, resp);
        } finally {
            em.close();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        if (action != null && action.equals("delete")) {
            String maDt = req.getParameter("maDt");
            if (maDt == null || maDt.isBlank()) {
                resp.sendRedirect(req.getContextPath() + "/quanly?msg=error");
                return;
            }

            EntityManager em = EntityManagerFactoryUtil.getEntityManager();
            try {
                DienThoaiDAO dao = new DienThoaiDAOImpls(em);
                try {
                    dao.delete(maDt.trim());
                    resp.sendRedirect(req.getContextPath() + "/quanly?msg=deleted");
                } catch (RuntimeException ex) {
                    resp.sendRedirect(req.getContextPath() + "/quanly?msg=error");
                }
            } finally {
                em.close();
            }
        } else {
            resp.sendRedirect(req.getContextPath() + "/quanly");
        }
    }
}
