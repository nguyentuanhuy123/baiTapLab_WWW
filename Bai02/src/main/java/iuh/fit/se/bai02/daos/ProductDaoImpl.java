package iuh.fit.se.bai02.daos;

import iuh.fit.se.bai02.daos.service.ProductDao;
import iuh.fit.se.bai02.models.Product;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao {
    private final DataSource dataSource;
    public ProductDaoImpl(DataSource dataSource){
        this.dataSource=dataSource;
    }

    @Override
    public List<Product> findAll() {

        String sql = "SELECT id, name, price, image FROM product";
        List<Product> list = new ArrayList<>();
        try (
                Connection con = (Connection) this.dataSource.getConnection();
                PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
        ) {
            while (rs.next()) {
                String id = rs.getString("id");
                String name = rs.getString("name");
                double price = rs.getDouble("price");
                String image = rs.getString("image");
                list.add(new Product(id, name, price,image));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Product getById(String id) {

        String sql = "SELECT id, name, price, image FROM product WHERE id=?";
        Product p = null;
        try (
                Connection con = (Connection) this.dataSource.getConnection();
                PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
        ){
            ps.setString(1, id);
            try (ResultSet rs = ps.executeQuery();) {
                while (rs.next()) {
                    String name = rs.getString("name");
                    Double price = rs.getDouble("price");
                    String image = rs.getString("image");
                    p = new Product(id, name, price,image);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return p;
    }

}
