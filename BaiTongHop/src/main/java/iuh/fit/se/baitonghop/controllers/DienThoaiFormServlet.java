package iuh.fit.se.baitonghop.controllers;

import iuh.fit.se.baitonghop.daos.DienThoaiDAO;
import iuh.fit.se.baitonghop.daos.NhaCungCapDAO;
import iuh.fit.se.baitonghop.daos.impls.DienThoaiDAOImpls;
import iuh.fit.se.baitonghop.daos.impls.NhaCungCapDAOImpls;
import iuh.fit.se.baitonghop.models.DienThoai;
import iuh.fit.se.baitonghop.models.NhaCungCap;
import iuh.fit.se.baitonghop.utils.EntityManagerFactoryUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

import java.io.IOException;
import java.util.*;

@WebServlet("/dt-form")
@MultipartConfig(fileSizeThreshold = 1024 * 1024,
        maxFileSize = 5 * 1024 * 1024,
        maxRequestSize = 10 * 1024 * 1024)
public class DienThoaiFormServlet extends HttpServlet {
    private Validator validator;
    private static final String UPLOAD_DIR = "images";

    @Override
    public void init() throws ServletException {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EntityManager em= EntityManagerFactoryUtil.getEntityManager();
        try {
            NhaCungCapDAO nhaCungCapDAO=new NhaCungCapDAOImpls(em);
            List<NhaCungCap> nccs=nhaCungCapDAO.findAll();

            req.setAttribute("nhaCungCaps", nccs);
            req.getRequestDispatcher("/views/DienThoaiForm.jsp").forward(req, resp);
        } finally {
            em.close();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EntityManager em = EntityManagerFactoryUtil.getEntityManager();
        try {
            req.setCharacterEncoding("UTF-8");
            String maDt = req.getParameter("maDt");
            String tenDt = req.getParameter("tenDt");
            String namSanXuat = req.getParameter("namSanXuat");
            String cauHinh = req.getParameter("cauHinh");
            String mancc = req.getParameter("mancc");
             Part   imagePart = req.getPart("hinhAnh");

            DienThoai dt = new DienThoai();
            dt.setMaDt(maDt != null ? maDt.trim() : null);
            dt.setTenDt(tenDt != null ? tenDt.trim() : null);
            dt.setNamSanXuat(namSanXuat != null ? namSanXuat.trim() : null);
            dt.setCauHinh(cauHinh != null ? cauHinh.trim() : null);

            if (mancc != null && !mancc.isBlank()) {
                NhaCungCap ncc = em.find(NhaCungCap.class, mancc);
                dt.setNcc(ncc);
            } else {
                dt.setNcc(null);
            }
            dt.setHinhAnh(imagePart.getSubmittedFileName());
            Set<ConstraintViolation<DienThoai>> violations = validator.validate(dt);

            if (!violations.isEmpty()) {
                Map<String, String> errors = new LinkedHashMap<>();
                for (ConstraintViolation<DienThoai> v : violations) {
                    String prop = v.getPropertyPath().toString();
                    errors.putIfAbsent(prop, v.getMessage());
                }
                NhaCungCapDAO nccDao = new NhaCungCapDAOImpls(em);
                List<NhaCungCap> nccs = nccDao.findAll();
                req.setAttribute("nhaCungCaps", nccs);

                req.setAttribute("errors", errors);
                req.setAttribute("maDt", maDt);
                req.setAttribute("tenDt", tenDt);
                req.setAttribute("namSanXuat", namSanXuat);
                req.setAttribute("cauHinh", cauHinh);
                req.setAttribute("mancc", mancc);

                req.getRequestDispatcher("/views/DienThoaiForm.jsp").forward(req, resp);
                return;
            }
            DienThoaiDAO dao = new DienThoaiDAOImpls(em);
            try {
                dao.add(dt);
            } catch (PersistenceException pe) {
                Map<String, String> serverErrors = new HashMap<>();
                serverErrors.put("server", "Lỗi khi lưu vào cơ sở dữ liệu: " + pe.getMessage());

                NhaCungCapDAO nccDao = new NhaCungCapDAOImpls(em);
                List<NhaCungCap> nccs = nccDao.findAll();
                req.setAttribute("nccs", nccs);

                req.setAttribute("errors", serverErrors);
                req.setAttribute("maDt", maDt);
                req.setAttribute("tenDt", tenDt);
                req.setAttribute("namSanXuat", namSanXuat);
                req.setAttribute("cauHinh", cauHinh);
                req.setAttribute("mancc", mancc);

                req.getRequestDispatcher("/views/DienThoaiForm.jsp").forward(req, resp);
                return;
            }
            resp.sendRedirect(req.getContextPath() + "/ncc");
        } finally {
            em.close();
        }
    }
}
