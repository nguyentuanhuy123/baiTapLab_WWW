package iuh.fit.se.lab08_bai1_3_fe.services;

import iuh.fit.se.lab08_bai1_3_fe.entities.Employee;
import iuh.fit.se.lab08_bai1_3_fe.utils.ApiResponse;
import iuh.fit.se.lab08_bai1_3_fe.utils.PageResponse;

import java.util.List;

public interface EmployeeService {
    public ApiResponse save(Employee employee);
    public ApiResponse findAll();
    public ApiResponse findById(int id);
    public ApiResponse update(Employee employee,int id);
    public ApiResponse delete(int id);
    public ApiResponse search(String kw);
    public PageResponse<Employee> findAllWithPaging(int page, int size, String sort);

}
