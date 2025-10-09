package iuh.fit.se.daos;

import iuh.fit.se.models.Employee;

import java.util.List;

public interface EmployeeDAO {
    public void update(Employee employee);
    public List<Employee> getAll();
    public Employee getById(int id);
    public void save(Employee employee);
}
