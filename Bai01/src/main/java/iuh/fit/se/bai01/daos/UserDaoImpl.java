package iuh.fit.se.bai01.daos;

import iuh.fit.se.bai01.daos.service.UserDao;
import iuh.fit.se.bai01.entites.User;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    private final DataSource dataSource;
    public UserDaoImpl(DataSource dataSource){
        this.dataSource=dataSource;
    }

    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        String sql = "SELECT first_name, last_name, email, birthday, gender FROM users";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                User u = new User(
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("email"),
                        null, // password không hiển thị
                        rs.getString("birthday"),
                        rs.getString("gender")
                );
                users.add(u);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // bạn có thể log thay vì in stack
        }
        return users;
    }

    @Override
    public boolean add(User user) {
        String sql = "INSERT INTO users(first_name, last_name, email, password, birthday, gender) VALUES (?,?,?,?,?,?)";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, user.getFirstName());
            ps.setString(2, user.getLastName());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getPassword());
            ps.setString(5, user.getBirthday());
            ps.setString(6, user.getGender());

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(User user) {
        String sql = "DELETE FROM users WHERE email = ?";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, user.getEmail());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}
