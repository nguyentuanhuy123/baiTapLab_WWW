package iuh.fit.se.lab08bai1.service;

import iuh.fit.se.lab08bai1.entities.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> findAll();
    public Employee findById(int id);
    public Employee save(Employee employee);
    public void delete(int id);
}
