package iuh.fit.se.baitonghop.daos.impls;

import iuh.fit.se.baitonghop.daos.DienThoaiDAO;
import iuh.fit.se.baitonghop.models.DienThoai;
import iuh.fit.se.baitonghop.models.NhaCungCap;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;

public class DienThoaiDAOImpls implements DienThoaiDAO {
    private EntityManager em;
    public DienThoaiDAOImpls(EntityManager em){
        this.em = em;
    }

    @Override
    public List<DienThoai> getByNcc(String ncc) {
        return em.createQuery("select dt from DienThoai dt where dt.ncc.maNcc = :ncc order by dt.ncc.maNcc", DienThoai.class)
                .setParameter("ncc", ncc)
                .getResultList();
    }

    @Override
    public List<DienThoai> findAll() {
        return em.createQuery("select dt from DienThoai dt order by dt.ncc.maNcc", DienThoai.class)
                .getResultList();
    }

    @Override
    public DienThoai add(DienThoai dt) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(dt);
            tx.commit();
            return dt;
        } catch (RuntimeException ex) {
            if (tx.isActive()) tx.rollback();
            throw ex;
        }
    }

    @Override
    public void delete(String ma) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            DienThoai managed = em.find(DienThoai.class, ma);
            if (managed != null) {
                em.remove(managed);
            }
            tx.commit();
        } catch (RuntimeException ex) {
            if (tx.isActive()) tx.rollback();
            throw ex;
        }
    }

    @Override
    public DienThoai update(DienThoai dt) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            DienThoai merged = em.merge(dt);
            tx.commit();
            return merged;
        } catch (RuntimeException ex) {
            if (tx.isActive()) tx.rollback();
            throw ex;
        }
    }
}
