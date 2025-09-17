package iuh.fit.se.bai03.daos.impl;

import iuh.fit.se.bai03.daos.DanhSachTinTucQuanLy;
import iuh.fit.se.bai03.models.TinTuc;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;

public class DanhSachTinTucQuanLyIpml implements DanhSachTinTucQuanLy {
    private EntityManager entityManager;
    public DanhSachTinTucQuanLyIpml(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    @Override
    public TinTuc save(TinTuc tinTuc) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(tinTuc);
            transaction.commit();
            return tinTuc;
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
        }
        return null;
    }

    @Override
    public boolean add(TinTuc tinTuc) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(tinTuc);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            return false;
        }
    }

    @Override
    public TinTuc update(TinTuc tinTuc) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.merge(tinTuc);
            transaction.commit();
            return tinTuc;
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
        }
        return null;
    }

    @Override
    public boolean delete(String maTT) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            TinTuc tinTuc = entityManager.find(TinTuc.class, maTT);
            if (tinTuc != null) {
                entityManager.remove(tinTuc);
            }
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
        }
        return false;
    }

    @Override
    public TinTuc findById(String maTT) {
        try {
            return entityManager.find(TinTuc.class, maTT);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<TinTuc> findAll() {
        try {
            return entityManager
                    .createQuery("SELECT t FROM TinTuc t", TinTuc.class)
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return List.of();
    }

    @Override
    public List<TinTuc> getByDanhMuc(String maDM) {
        try {
            return entityManager
                    .createQuery("SELECT t FROM TinTuc t WHERE t.danhMuc.maDM = :maDM", TinTuc.class)
                    .setParameter("maDM", maDM)
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return List.of();
    }
}
