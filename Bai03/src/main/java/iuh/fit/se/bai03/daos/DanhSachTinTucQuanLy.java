package iuh.fit.se.bai03.daos;

import iuh.fit.se.bai03.models.TinTuc;

import java.util.List;

public interface DanhSachTinTucQuanLy {
    public List<TinTuc> findAll();
    public boolean add(TinTuc tinTuc);
    public boolean delete(String maTT);
    public List<TinTuc> getByDanhMuc(String maDM);
    public TinTuc save(TinTuc tinTuc);
    public TinTuc update(TinTuc tinTuc);
    public TinTuc findById(String maTT);

}
