package iuh.fit.se.bai02.javabased.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Component
public class Employee {
    private int id;
    private String name;
    private Address address;
}
