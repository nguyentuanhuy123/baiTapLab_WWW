package iuh.fit.se.bai02.annotationbased.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Component
public class Employee {
    private int id=1;
    private String name="Nguyen Van A";
    @Autowired
    private Address address;
}
