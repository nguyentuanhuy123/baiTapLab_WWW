package iuh.fit.se.baitonghop.daos;

import iuh.fit.se.baitonghop.models.DienThoai;

import java.util.List;

public interface DienThoaiDAO {
    public List<DienThoai> getByNcc(String ncc);
    public List<DienThoai> findAll();
    public DienThoai add(DienThoai dt);
    public void delete(String ma);
    public DienThoai update(DienThoai dt);
}
