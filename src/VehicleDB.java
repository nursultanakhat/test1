import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VehicleDB implements VehicleRepository {

    @Override
    public void create(Connection conn, String model, double price, boolean available) throws SQLException {
        String sql = "INSERT INTO vehicle (model, price, available) VALUES (?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, model);
            ps.setDouble(2, price);
            ps.setBoolean(3, available);
            ps.executeUpdate();
        }
    }

    @Override
    public List<String> readAll(Connection conn) throws SQLException {
        String sql = "SELECT id, model, price, available FROM vehicle ORDER BY id";
        List<String> result = new ArrayList<>();

        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String model = rs.getString("model");
                double price = rs.getDouble("price");
                boolean available = rs.getBoolean("available");

                String status = available ? "Available" : "Rented";

                result.add(
                        "Vehicle -> ID: " + id +
                                ", Model: " + model +
                                ", Price: " + price +
                                ", Status: " + status
                );
            }
        }
        return result;
    }

    @Override
    public void updatePrice(Connection conn, int id, double newPrice) throws SQLException {
        String sql = "UPDATE vehicle SET price = ? WHERE id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setDouble(1, newPrice);
            ps.setInt(2, id);
            ps.executeUpdate();
        }
    }

    @Override
    public void updateAvailability(Connection conn, int id, boolean available) throws SQLException {
        String sql = "UPDATE vehicle SET available = ? WHERE id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setBoolean(1, available);
            ps.setInt(2, id);
            ps.executeUpdate();
        }
    }

    @Override
    public void delete(Connection conn, int id) throws SQLException {
        String sql = "DELETE FROM vehicle WHERE id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    // ✅ ОБЯЗАТЕЛЬНЫЙ метод из VehicleRepository
    @Override
    public Boolean isAvailableById(Connection conn, int id) throws SQLException {
        String sql = "SELECT available FROM vehicle WHERE id = ?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getBoolean("available");
                }
                return null; // vehicle not found
            }
        }
    }
}
