package iuh.fit.se;

import iuh.fit.se.daos.EmployeeDAO;
import iuh.fit.se.models.Employee;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication(scanBasePackages = {"iuh.fit.se.daos","iuh.fit.se.daos.impls"})
public class SpringMain {
    public static void main(String[] args) {
        SpringApplication.run(SpringMain.class,args);
    }
    @Bean
    CommandLineRunner runner(EmployeeDAO employeeDAO){
        return args -> {
            Employee employee=new Employee();
            employee.setName("Nguyen Van A");
            employee.setRole("Super Admin");
            employeeDAO.save(employee);

            List<Employee> employees=employeeDAO.getAll();
            employees.forEach(System.out::println);

            Employee employee2=employeeDAO.getById(1);
            System.out.println(employee2);


        };
    }
}
