package iuh.fit.se.lab08bai2.services.impl;

import iuh.fit.se.lab08bai2.entities.NhaCungCap;
import iuh.fit.se.lab08bai2.repositories.NhaCungCapRepository;
import iuh.fit.se.lab08bai2.services.NhaCungCapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NhaCungCapServiceImpl implements NhaCungCapService {
    NhaCungCapRepository repository;
    @Autowired
    public  NhaCungCapServiceImpl(NhaCungCapRepository repository){
        this.repository=repository;
    }

    @Override
    public NhaCungCap findById(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<NhaCungCap> findAll() {
        return repository.findAll();
    }
}
