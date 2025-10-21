package iuh.fit.se.bai2.services.impl;

import iuh.fit.se.bai2.models.DienThoai;
import iuh.fit.se.bai2.repositories.DienThoaiRepository;
import iuh.fit.se.bai2.services.DienThoaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class DienThoaiServiceImpl implements DienThoaiService {

    private final DienThoaiRepository repository;

    @Autowired
    public DienThoaiServiceImpl(DienThoaiRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<DienThoai> getByDanhMuc(List<String> ids) {
        if (ids == null || ids.isEmpty()) {
            return List.of();
        }
        return repository.findByNccMaNccIn(ids);
    }

    @Override
    @Transactional
    public boolean add(DienThoai dienThoai) {
        if (dienThoai == null || dienThoai.getMaDt() == null) {
            return false;
        }
        Optional<DienThoai> existed = repository.findById(dienThoai.getMaDt());
        if (existed.isPresent()) {
            return false;
        }
        repository.save(dienThoai);
        return true;
    }

    @Override
    @Transactional
    public void delete(String id) {
        if (id == null) return;
        repository.deleteById(id);
    }
}
