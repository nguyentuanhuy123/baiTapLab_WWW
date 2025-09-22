package iuh.fit.se.baitonghop.daos;

import iuh.fit.se.baitonghop.models.NhaCungCap;

import java.util.List;

public interface NhaCungCapDAO {
    public List<NhaCungCap> findAll();
    public List<NhaCungCap> search(String kw);
}
