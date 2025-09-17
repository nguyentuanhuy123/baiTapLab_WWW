package iuh.fit.se.bai01.entites;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String birthday;
    private String gender;

}
