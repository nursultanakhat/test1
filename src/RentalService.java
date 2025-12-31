import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class RentalService {

    private List<Vehicle> vehicles = new ArrayList<>();

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }
    public List<Vehicle> getAllVehicles() {
        return new ArrayList<>(vehicles);
    }
    public List<Vehicle> filterAvailable() {
        List<Vehicle> result = new ArrayList<>();
        for (Vehicle v : vehicles) {
            if (v.isAvailable()) {
                result.add(v);
            }
        }
        return result;
    }
    public List<Vehicle> searchByModel(String text) {
        List<Vehicle> result = new ArrayList<>();
        String t = text.toLowerCase();

        for (Vehicle v : vehicles) {
            if (v.getModel().toLowerCase().contains(t)) {
                result.add(v);
            }
        }
        return result;
    }
    public List<Vehicle> sortByPrice() {
        List<Vehicle> copy = new ArrayList<>(vehicles);
        copy.sort(Comparator.comparingDouble(Vehicle::getPrice));
        return copy;
    }
    public List<Vehicle> sortByModel() {
        List<Vehicle> copy = new ArrayList<>(vehicles);
        copy.sort(Comparator.comparing(Vehicle::getModel));
        return copy;
    }
    public double TotalPrice(Vehicle vehicle, int days) {
        return vehicle.getPrice() * days;
    }

    public void rentVehicle(Vehicle vehicle, Client client, int days) {
        if (vehicle.isAvailable()) {
            vehicle.setAvailable(false);
            double total = TotalPrice(vehicle, days);
            System.out.println(client.getName() + " rented " +
                    vehicle.getModel() + " for " + days +
                    " days. Total price: " + total);
        } else {
            System.out.println("Vehicle is not available.");
        }
    }
}


