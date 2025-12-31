public class Main {

    public static void main(String[] args) {

        RentalService service = new RentalService();

        Vehicle car1 = new Car("Toyota Camry", 50.0, true, 5);
        Vehicle car2 = new Car("BMW X5", 120.0, true, 5);
        Vehicle bike1 = new Bike("Xiaomi Scooter", 20.0, true, true);

        service.addVehicle(car1);
        service.addVehicle(car2);
        service.addVehicle(bike1);

        Client client1 = new Client("Nursultan", 21);

        System.out.println("ALL VEHICLES ");
        for (Vehicle v : service.getAllVehicles()) {
            v.printInfo();
        }

        System.out.println("\n AVAILABLE VEHICLES ");
        for (Vehicle v : service.filterAvailable()) {
            v.printInfo();
        }

        System.out.println("\n SEARCH BY MODEL: BMW ");
        for (Vehicle v : service.searchByModel("BMW")) {
            v.printInfo();
        }

        System.out.println("\n SORT BY PRICE");
        for (Vehicle v : service.sortByPrice()) {
            v.printInfo();
        }

        System.out.println("\n RENT PROCESS");
        service.rentVehicle(car2, client1, 3);

        System.out.println("\nVEHICLES STATUS AFTER RENT");
        for (Vehicle v : service.getAllVehicles()) {
            v.printInfo();
        }
    }
}

