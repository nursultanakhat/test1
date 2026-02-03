import java.sql.Connection;
import java.util.List;

public interface VehicleRepository {
    void create(Connection conn, String model, double price, boolean available) throws Exception;
    List<String> readAll(Connection conn) throws Exception;
    void updatePrice(Connection conn, int id, double newPrice) throws Exception;
    void updateAvailability(Connection conn, int id, boolean available) throws Exception;
    void delete(Connection conn, int id) throws Exception;

    Boolean isAvailableById(Connection conn, int id) throws Exception; // NEW
}

