package iuh.fit.se.baitonghop.daos.impls;

import iuh.fit.se.baitonghop.daos.NhaCungCapDAO;
import iuh.fit.se.baitonghop.models.NhaCungCap;
import jakarta.persistence.EntityManager;

import java.util.List;

public class NhaCungCapDAOImpls implements NhaCungCapDAO {
    private EntityManager em;
    public NhaCungCapDAOImpls(EntityManager em){
        this.em=em;
    }

    @Override
    public List<NhaCungCap> findAll() {

            return em.createQuery("select n from NhaCungCap n order by n.maNcc",NhaCungCap.class).getResultList();

    }

    @Override
    public List<NhaCungCap> search(String kw) {
        String jpql="select n from NhaCungCap n where n.maNcc like :kw or n.tenNhaNcc like :kw or n.diaChi like :kw or n.soDienThoai like :kw";
        return em.createQuery(jpql, NhaCungCap.class)
                .setParameter("kw",kw)
                .getResultList();
    }
}
