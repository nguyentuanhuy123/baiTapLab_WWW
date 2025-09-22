package iuh.fit.se.baitonghop.controllers;

import iuh.fit.se.baitonghop.daos.DienThoaiDAO;
import iuh.fit.se.baitonghop.daos.NhaCungCapDAO;
import iuh.fit.se.baitonghop.daos.impls.DienThoaiDAOImpls;
import iuh.fit.se.baitonghop.daos.impls.NhaCungCapDAOImpls;
import iuh.fit.se.baitonghop.models.DienThoai;
import iuh.fit.se.baitonghop.models.NhaCungCap;
import iuh.fit.se.baitonghop.utils.EntityManagerFactoryUtil;
import jakarta.persistence.EntityManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
@WebServlet("/dienthoai")
public class DanhSachDienThoaiServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String mancc=req.getParameter("mancc");
        if(mancc==null||mancc.isEmpty()){
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST,"THieu ma ncc");
            return;
        }

        EntityManager em= EntityManagerFactoryUtil.getEntityManager();
        try{
            DienThoaiDAO dienThoaiDAO=new DienThoaiDAOImpls(em);



            List<DienThoai> dienThoais=dienThoaiDAO.getByNcc(mancc);

            req.setAttribute("dienThoais",dienThoais);

            req.getRequestDispatcher("/views/DanhSachDienThoaiTheoNCC.jsp").forward(req,resp);

        }finally {
            em.close();
        }
        }
}
