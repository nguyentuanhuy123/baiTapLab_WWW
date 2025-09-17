package iuh.fit.se.bai03.controllers;

import iuh.fit.se.bai03.daos.DanhSachTinTucQuanLy;
import iuh.fit.se.bai03.daos.impl.DanhMucDAOImpl;
import iuh.fit.se.bai03.daos.impl.DanhSachTinTucQuanLyIpml;
import iuh.fit.se.bai03.models.DanhMuc;
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

@WebServlet("/danh-sach-tin-tuc")
public class DanhSachTinTucServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        EntityManager em = EntityManagerFactoryUtil.getEntityManager();
        DanhSachTinTucQuanLy danhSachTinTucQuanLy = new DanhSachTinTucQuanLyIpml(em);
        DanhMucDAOImpl danhMucDAO = new DanhMucDAOImpl(em);

        String maDM = req.getParameter("maDM");
        List<TinTuc> tinTucList;
        if (maDM != null && !maDM.isEmpty()) {
            tinTucList = danhSachTinTucQuanLy.getByDanhMuc(maDM);
        } else {
            tinTucList = danhSachTinTucQuanLy.findAll();
        }

        List<DanhMuc> danhMucs = danhMucDAO.findAll();

        req.setAttribute("tinTucList", tinTucList);
        req.setAttribute("danhMucs", danhMucs);

        req.getRequestDispatcher("/views/DanhSachTinTuc.jsp").forward(req, resp);
        em.close();
    }
}
