package iuh.fit.se.lab08bai2.services.impl;

import iuh.fit.se.lab08bai2.entities.DienThoai;
import iuh.fit.se.lab08bai2.entities.NhaCungCap;
import iuh.fit.se.lab08bai2.repositories.DienThoaiRepository;
import iuh.fit.se.lab08bai2.services.DienThoaiService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DienThoaiServiceImpl implements DienThoaiService{
    DienThoaiRepository repository;
    @Autowired
    public DienThoaiServiceImpl(DienThoaiRepository repository){
        this.repository=repository;
    }

    @Override
    public List<DienThoai> findAll() {
        return repository.findAll();
    }

    @Override
    public List<DienThoai> findByNcc(NhaCungCap nhaCungCap) {
        return repository.findByNcc(nhaCungCap);
    }

    @Override
    @Transactional
    public DienThoai save(DienThoai dienThoai) {
        return repository.save(dienThoai);
    }

    @Override
    @Transactional
    public void delete(String id) {
        repository.deleteById(id);
    }
}
