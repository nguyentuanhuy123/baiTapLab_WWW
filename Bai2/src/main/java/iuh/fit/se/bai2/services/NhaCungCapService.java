package iuh.fit.se.bai2.services;

import iuh.fit.se.bai2.models.NhaCungCap;

import java.util.List;
import java.util.Optional;

public interface NhaCungCapService {
    public List<NhaCungCap> findAll();
    public List<NhaCungCap> search(String kw);
    Optional<NhaCungCap> findById(String id);
}
