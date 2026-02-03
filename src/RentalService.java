import java.sql.Connection;

public class RentalService {

    private final VehicleRepository vehicleRepo;

    public RentalService(VehicleRepository vehicleRepo) {
        this.vehicleRepo = vehicleRepo;
    }

    public void rentVehicle(Connection conn, int vehicleId, int days) throws Exception {
        if (days <= 0) {
            throw new IllegalArgumentException("Days must be greater than 0");
        }

        Boolean available = vehicleRepo.isAvailableById(conn, vehicleId);

        if (available == null) {
            System.out.println("Vehicle with this ID not found.");
            return;
        }

        if (!available) {
            System.out.println("Vehicle is already rented.");
            return;
        }

        vehicleRepo.updateAvailability(conn, vehicleId, false);
        System.out.println("Vehicle rented successfully.");
    }

    public void returnVehicle(Connection conn, int vehicleId) throws Exception {
        Boolean available = vehicleRepo.isAvailableById(conn, vehicleId);

        if (available == null) {
            System.out.println("Vehicle with this ID not found.");
            return;
        }

        if (available) {
            System.out.println("Vehicle is already available.");
            return;
        }

        vehicleRepo.updateAvailability(conn, vehicleId, true);
        System.out.println("Vehicle returned successfully.");
    }
}

