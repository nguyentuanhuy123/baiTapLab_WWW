package iuh.fit.se.bai03.controllers;

import iuh.fit.se.bai03.daos.DanhSachTinTucQuanLy;
import iuh.fit.se.bai03.daos.impl.DanhSachTinTucQuanLyIpml;
import iuh.fit.se.bai03.models.TinTuc;
import iuh.fit.se.bai03.utils.EntityManagerFactoryUtil;
import jakarta.persistence.EntityManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/quan-ly-tin-tuc")
public class QuanLyFormServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        EntityManager em = EntityManagerFactoryUtil.getEntityManager();
        DanhSachTinTucQuanLy danhSachTinTucQuanLy = new DanhSachTinTucQuanLyIpml(em);
        List<TinTuc> tinTucs = danhSachTinTucQuanLy.findAll();

        req.setAttribute("tinTucs", tinTucs);
        req.getRequestDispatcher("/views/QuanLyForm.jsp").forward(req, resp);
        em.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String maTT = req.getParameter("maTT");

        EntityManager em = EntityManagerFactoryUtil.getEntityManager();
        DanhSachTinTucQuanLy danhSachTinTucQuanLy = new DanhSachTinTucQuanLyIpml(em);

        boolean deleted = danhSachTinTucQuanLy.delete(maTT);

        if (deleted) {
            resp.sendRedirect(req.getContextPath() + "/quan-ly-tin-tuc");
        } else {
            req.setAttribute("error", "Xóa tin tức thất bại!");
            doGet(req, resp);
        }
        em.close();
    }
}