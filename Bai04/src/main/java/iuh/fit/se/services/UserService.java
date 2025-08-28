package iuh.fit.se.services;
import iuh.fit.se.models.User;

import jakarta.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class UserService {
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        users.add(new User(1, "Nguyen Van A", "a@gmail.com"));
        users.add(new User(2, "Tran Thi B", "b@gmail.com"));
        users.add(new User(3, "Le Van C", "c@gmail.com"));
        return users;
    }
}

