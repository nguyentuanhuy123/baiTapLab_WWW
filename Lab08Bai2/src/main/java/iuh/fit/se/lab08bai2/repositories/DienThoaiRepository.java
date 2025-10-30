package iuh.fit.se.lab08bai2.repositories;

import iuh.fit.se.lab08bai2.entities.DienThoai;
import iuh.fit.se.lab08bai2.entities.NhaCungCap;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DienThoaiRepository extends JpaRepository<DienThoai,String> {
    List<DienThoai> findByNcc(NhaCungCap ncc);
}
