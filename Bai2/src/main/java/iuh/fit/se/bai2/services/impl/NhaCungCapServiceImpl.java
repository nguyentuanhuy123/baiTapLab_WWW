package iuh.fit.se.bai2.services.impl;

import iuh.fit.se.bai2.models.NhaCungCap;
import iuh.fit.se.bai2.repositories.NhaCungCapRepository;
import iuh.fit.se.bai2.services.NhaCungCapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NhaCungCapServiceImpl implements NhaCungCapService {

    private final NhaCungCapRepository repository;

    @Autowired
    public NhaCungCapServiceImpl(NhaCungCapRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<NhaCungCap> findAll() {
        return repository.findAll();
    }

    @Override
    public List<NhaCungCap> search(String kw) {
        if (kw == null || kw.trim().isEmpty()) {
            return repository.findAll();
        }
        return repository.findByTenNhaCcContainingIgnoreCase(kw.trim());
    }

    @Override
    public Optional<NhaCungCap> findById(String id) {
        return repository.findById(id);
    }
}
