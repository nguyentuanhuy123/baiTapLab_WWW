package iuh.fit.se.bai2.repositories;

import iuh.fit.se.bai2.models.NhaCungCap;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NhaCungCapRepository extends JpaRepository<NhaCungCap,String> {
    List<NhaCungCap> findByTenNhaCcContainingIgnoreCase(String kw);
}
