import java.sql.Connection;
import java.sql.DriverManager;

public class Main {
    public static void main(String[] args) {

        String url = "jdbc:postgresql://localhost:5432/VehicleRentalService";
        String user = "postgres";
        String password = "0000";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            System.out.println("Connected to Database!");

            VehicleRepository vehicleRepo = new VehicleDB();
            ClientRepository clientRepo = new ClientDB();

            Menu menu = new Menu(conn, vehicleRepo, clientRepo);
            menu.start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

