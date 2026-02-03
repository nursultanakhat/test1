import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientDB implements ClientRepository {

    @Override
    public void create(Connection conn, String name, int age) throws SQLException {
        String sql = "INSERT INTO client (name, age) VALUES (?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, name);
            ps.setInt(2, age);
            ps.executeUpdate();
        }
    }

    @Override
    public List<String> readAll(Connection conn) throws SQLException {
        String sql = "SELECT id, name, age FROM client ORDER BY id";
        List<String> result = new ArrayList<>();

        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");

                result.add(
                        "Client -> ID: " + id +
                                ", Name: " + name +
                                ", Age: " + age
                );
            }
        }
        return result;
    }

    @Override
    public void updateAge(Connection conn, int id, int newAge) throws SQLException {
        String sql = "UPDATE client SET age = ? WHERE id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, newAge);
            ps.setInt(2, id);
            ps.executeUpdate();
        }
    }

    @Override
    public void delete(Connection conn, int id) throws SQLException {
        String sql = "DELETE FROM client WHERE id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
}
