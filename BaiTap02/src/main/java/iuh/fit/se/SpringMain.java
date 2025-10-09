package iuh.fit.se;


import iuh.fit.se.models.Employee;
import iuh.fit.se.repositories.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class SpringMain {
    public static void main(String[] args) {
        SpringApplication.run(SpringMain.class,args);
    }
    @Bean
    CommandLineRunner runner(EmployeeRepository employeeRepository){
        return args -> {
            Employee employee = new Employee();
            employee.setName("Nguyen Van A");
            employee.setRole("Super Admin");
            employeeRepository.save(employee);
            System.out.println("Đã thêm: " + employee);

            List<Employee> employees = employeeRepository.findAll();
            System.out.println("Danh sách tất cả nhân viên:");
            employees.forEach(System.out::println);

            employeeRepository.findById(employee.getId()).ifPresent(e -> System.out.println("Tìm theo id: " + e));

            employee.setRole("Admin Update");
            employeeRepository.save(employee);
            System.out.println("Cập nhật: " + employee);

            employeeRepository.deleteById(employee.getId());
            System.out.println("Đã xóa nhân viên với id: " + employee.getId());

            List<Employee> employeesAfterDelete = employeeRepository.findAll();
            System.out.println("Danh sách sau khi xóa:");
            employeesAfterDelete.forEach(System.out::println);
        };
    }

}
