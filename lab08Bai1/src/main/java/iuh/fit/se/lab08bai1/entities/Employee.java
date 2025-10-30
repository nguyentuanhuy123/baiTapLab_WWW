package iuh.fit.se.lab08bai1.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    @NotEmpty(message = "firstName khong duoc null")
    private String firstName;
    @NotEmpty(message = "lastName khong duoc null")
    private String lastName;
    @NotEmpty(message = "gender khong duoc null")
    private String gender;
    @NotNull(message = "dob khong duoc null")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dob;
    @NotEmpty(message = "email khong duoc null")
    private String email;
    @NotEmpty(message = "phone khong duoc null")
    private String phone;
}
