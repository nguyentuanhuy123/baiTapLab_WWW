package iuh.fit.se.lab08bai2.services;

import iuh.fit.se.lab08bai2.entities.NhaCungCap;

import java.util.List;

public interface NhaCungCapService {
    public NhaCungCap findById(String id);
    public List<NhaCungCap> findAll();
}
