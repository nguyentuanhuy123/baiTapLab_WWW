package iuh.fit.se.bai1.services;

import iuh.fit.se.bai1.entities.Employee;

import java.util.List;

public interface EmployeeService {
    public Employee save(Employee employee);
    public List<Employee> findAll();
    public Employee findById(int id);
    public void deleteById(int id);
}
