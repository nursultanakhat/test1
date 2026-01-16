import java.util.List;
import java.util.Scanner;

public class Menu {

    private Scanner sc = new Scanner(System.in);
    private RentalService service = new RentalService();

    public Menu() {
        // начальные данные (чтобы меню сразу работало)
        service.addVehicle(new Car("Toyota Camry", 50.0, true, 5));
        service.addVehicle(new Car("BMW X5", 120.0, true, 5));
        service.addVehicle(new Bike("Xiaomi Scooter", 20.0, true, true));
    }

    public void start() {
        while (true) {
            showMenu();
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> showAllVehicles();
                case 2 -> showAvailableVehicles();
                case 3 -> searchByModel();
                case 4 -> sortByPrice();
                case 5 -> rentVehicle();
                case 0 -> {
                    System.out.println("Exit program.");
                    return;
                }
                default -> System.out.println("Wrong choice.");
            }
        }
    }

    private void showMenu() {
        System.out.println("\n=== VEHICLE RENTAL MENU ===");
        System.out.println("1) Show all vehicles");
        System.out.println("2) Show available vehicles");
        System.out.println("3) Search vehicle by model");
        System.out.println("4) Sort vehicles by price");
        System.out.println("5) Rent vehicle");
        System.out.println("0) Exit");
        System.out.print("Choose: ");
    }

    private void showAllVehicles() {
        List<Vehicle> list = service.getAllVehicles();
        for (Vehicle v : list) {
            System.out.println(v);
        }
    }

    private void showAvailableVehicles() {
        List<Vehicle> list = service.filterAvailable();
        for (Vehicle v : list) {
            System.out.println(v);
        }
    }

    private void searchByModel() {
        System.out.print("Enter model text: ");
        String text = sc.nextLine();

        List<Vehicle> list = service.searchByModel(text);
        for (Vehicle v : list) {
            System.out.println(v);
        }
    }

    private void sortByPrice() {
        List<Vehicle> list = service.sortByPrice();
        for (Vehicle v : list) {
            System.out.println(v);
        }
    }

    private void rentVehicle() {
        System.out.print("Enter vehicle ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        Vehicle vehicle = null;
        for (Vehicle v : service.getAllVehicles()) {
            if (v.getId() == id) {
                vehicle = v;
                break;
            }
        }

        if (vehicle == null) {
            System.out.println("Vehicle not found.");
            return;
        }

        System.out.print("Enter days: ");
        int days = sc.nextInt();
        sc.nextLine();

        Client client = new Client("Nursultan", 21);
        service.rentVehicle(vehicle, client, days);
    }
}

