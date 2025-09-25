package iuh.fit.se.bai02.javabased;

import iuh.fit.se.bai02.javabased.models.Address;
import iuh.fit.se.bai02.javabased.models.Employee;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("iuh.fit.se.bai02.annotationbased.models")
public class AppConfig {
    @Bean
    public Address address1(){
        return new Address("Los Angeles","California","USA");
    }
    @Bean
    public Address address2(){
        return new Address("San Francisc","California","USA");
    }
    @Bean
    public Employee employee1(){
        return new Employee(1,"Nguyen Van A",address1());
    }
}
