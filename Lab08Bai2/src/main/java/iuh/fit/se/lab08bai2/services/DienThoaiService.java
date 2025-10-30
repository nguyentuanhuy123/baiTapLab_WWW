package iuh.fit.se.lab08bai2.services;

import iuh.fit.se.lab08bai2.entities.DienThoai;
import iuh.fit.se.lab08bai2.entities.NhaCungCap;

import java.util.List;

public interface DienThoaiService {
    public List<DienThoai> findAll();
    public List<DienThoai> findByNcc(NhaCungCap nhaCungCap);
    public DienThoai save(DienThoai dienThoai);
    public void delete(String id);
}
