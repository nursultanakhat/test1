public class RentalService {

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

