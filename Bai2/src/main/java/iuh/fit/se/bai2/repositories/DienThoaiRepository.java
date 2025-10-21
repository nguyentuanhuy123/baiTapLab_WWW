package iuh.fit.se.bai2.repositories;


import iuh.fit.se.bai2.models.DienThoai;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface DienThoaiRepository extends JpaRepository<DienThoai,String> {
    List<DienThoai> findByNccMaNccIn(List<String> ids);
}
