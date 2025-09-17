package iuh.fit.se.bai03.daos.impl;

import iuh.fit.se.bai03.daos.DanhMucDAO;
import iuh.fit.se.bai03.models.DanhMuc;
import iuh.fit.se.bai03.utils.EntityManagerFactoryUtil;
import jakarta.persistence.EntityManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DanhMucDAOImpl implements DanhMucDAO {
    private EntityManager entityManager;
    public DanhMucDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<DanhMuc> findAll() {
        try {
            return entityManager.createQuery("SELECT d FROM DanhMuc d", DanhMuc.class).getResultList();
        } finally {
            entityManager.close();
        }
    }

}
