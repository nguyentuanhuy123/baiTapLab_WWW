package iuh.fit.se.bai01.daos.service;

import iuh.fit.se.bai01.entites.User;

import java.util.List;

public interface UserDao {
    public List<User> findAll();
    public boolean add(User user);
    public boolean delete(User user);
}
