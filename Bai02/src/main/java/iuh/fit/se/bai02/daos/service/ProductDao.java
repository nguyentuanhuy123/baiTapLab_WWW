package iuh.fit.se.bai02.daos.service;

import iuh.fit.se.bai02.models.Product;

import java.util.List;

public interface ProductDao {
    public List<Product> findAll();
    public Product getById(String id);

}
