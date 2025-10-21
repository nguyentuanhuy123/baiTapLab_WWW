package iuh.fit.se.bai1.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
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
    @Past(message = "dob phai truoc ngay hien tai")
    private LocalDate dob;
    @NotEmpty(message = "email khong de trong")
    @Email(message = "email khong hop le")
    private String email;
    @NotEmpty(message = "phone khong de trong")
    @Pattern(regexp = "^(\\+?\\d{9,15})?$", message = "phone khong hop le")
    private String phone;

}
