package iuh.fit.se.bai2.repositories;


import iuh.fit.se.bai2.models.DienThoai;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface DienThoaiRepository extends JpaRepository<DienThoai,String> {
}
