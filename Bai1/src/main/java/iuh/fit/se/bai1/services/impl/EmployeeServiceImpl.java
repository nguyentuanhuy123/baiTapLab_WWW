package iuh.fit.se.bai1.services.impl;

import iuh.fit.se.bai1.entities.Employee;
import iuh.fit.se.bai1.repositories.EmployeeRepository;
import iuh.fit.se.bai1.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService {
    EmployeeRepository repository;
    @Autowired
    public EmployeeServiceImpl(EmployeeRepository repository){
        this.repository=repository;
    }
    @Override
    public Employee save(Employee employee) {
        return repository.save(employee);
    }

    @Override
    public List<Employee> findAll() {
        return repository.findAll();
    }

    @Override
    public Employee findById(int id) {
        return repository.findById(id).orElse(null);
    }
}
