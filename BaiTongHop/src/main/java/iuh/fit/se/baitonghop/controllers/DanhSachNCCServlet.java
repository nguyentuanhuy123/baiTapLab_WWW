package iuh.fit.se.baitonghop.controllers;

import iuh.fit.se.baitonghop.daos.NhaCungCapDAO;
import iuh.fit.se.baitonghop.daos.impls.NhaCungCapDAOImpls;
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

@WebServlet("/ncc")
public class DanhSachNCCServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String kw=req.getParameter("kw");
        EntityManager em= EntityManagerFactoryUtil.getEntityManager();
        try{
            NhaCungCapDAO nhaCungCapDAO=new NhaCungCapDAOImpls(em);

            List<NhaCungCap> nhaCungCaps;
            if(kw!=null&& !kw.trim().isEmpty()){
                nhaCungCaps=nhaCungCapDAO.search(kw);
            }else{
                nhaCungCaps=nhaCungCapDAO.findAll();
            }
            req.setAttribute("nhaCungCaps",nhaCungCaps);
            req.getRequestDispatcher("/views/DanhSachNCC.jsp").forward(req,resp);

        }finally {
            em.close();
        }
        }
}
