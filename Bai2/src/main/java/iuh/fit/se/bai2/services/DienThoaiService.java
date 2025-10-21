package iuh.fit.se.bai2.services;



import iuh.fit.se.bai2.models.DienThoai;

import java.util.List;

public interface DienThoaiService {
    public List<DienThoai> getByDanhMuc(List<String> ids);
    public boolean add(DienThoai dienThoai);
    public void delete(String id);
}
