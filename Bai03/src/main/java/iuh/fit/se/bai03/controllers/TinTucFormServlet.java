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
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

import java.io.IOException;
import java.util.List;
import java.util.Set;

@WebServlet("/them-tin-tuc")
public class TinTucFormServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        EntityManager em = EntityManagerFactoryUtil.getEntityManager();
        DanhMucDAOImpl danhMucDAO = new DanhMucDAOImpl(em);
        List<DanhMuc> danhMucs = danhMucDAO.findAll();
        req.setAttribute("danhMucs", danhMucs);
        req.getRequestDispatcher("/views/TinTucForm.jsp").forward(req, resp);
        em.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String maTT = req.getParameter("maTT");
        String tieuDe = req.getParameter("tieuDe");
        String noiDung = req.getParameter("noiDung");
        String lienKet = req.getParameter("lienKet");
        String maDM = req.getParameter("maDM");

        EntityManager em = EntityManagerFactoryUtil.getEntityManager();
        DanhMuc danhMuc = em.find(DanhMuc.class, maDM);

        TinTuc tinTuc = new TinTuc(maTT, tieuDe, noiDung, lienKet, danhMuc);

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<TinTuc>> violations = validator.validate(tinTuc);

        if (!violations.isEmpty()) {
            StringBuilder errorMsg = new StringBuilder();
            for (ConstraintViolation<TinTuc> v : violations) {
                errorMsg.append(v.getMessage()).append("<br>");
            }
            req.setAttribute("error", errorMsg.toString());

            DanhMucDAOImpl danhMucDAO = new DanhMucDAOImpl(em);
            List<DanhMuc> danhMucs = danhMucDAO.findAll();
            req.setAttribute("danhMucs", danhMucs);

            req.getRequestDispatcher("/views/TinTucForm.jsp").forward(req, resp);
            em.close();
            return;
        }

        DanhSachTinTucQuanLy danhSachTinTucQuanLy = new DanhSachTinTucQuanLyIpml(em);
        boolean added = danhSachTinTucQuanLy.add(tinTuc);

        if (added) {
            resp.sendRedirect(req.getContextPath() + "/danh-sach-tin-tuc");
        } else {
            req.setAttribute("error", "Thêm tin tức thất bại!");
            doGet(req, resp);
        }
        em.close();
    }
}
