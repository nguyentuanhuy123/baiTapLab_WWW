package iuh.fit.se.bai1.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotEmpty(message = "firstName khong de trong")
    private String firstName;
    @NotEmpty(message = "lastName khong de trong")
    private String lastName;
    @NotEmpty(message = "gender khong de trong")
    private String gender;
    @NotNull(message = "dob khong de trong")
    private LocalDate dob;
    @NotEmpty(message = "email khong de trong")
    private String email;
    @NotEmpty(message = "phone khong de trong")
    private String phone;

}
