import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

public class Menu {

    private final Scanner sc = new Scanner(System.in);

    private final Connection conn;
    private final VehicleRepository vehicleRepo;
    private final ClientRepository clientRepo;

    public Menu(Connection conn, VehicleRepository vehicleRepo, ClientRepository clientRepo) {
        this.conn = conn;
        this.vehicleRepo = vehicleRepo;
        this.clientRepo = clientRepo;
    }

    public void start() {
        while (true) {
            showMenu();
            int choice = readInt();

            try {
                switch (choice) {
                    case 1 -> showVehicles();
                    case 2 -> addVehicle();
                    case 3 -> updateVehiclePrice();
                    case 4 -> updateVehicleStatus();
                    case 5 -> deleteVehicle();

                    case 6 -> showClients();
                    case 7 -> addClient();
                    case 8 -> updateClientAge();
                    case 9 -> deleteClient();

                    case 0 -> {
                        System.out.println("Exit.");
                        return;
                    }
                    default -> System.out.println("Wrong choice.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private void showMenu() {
        System.out.println("\n1) Show vehicles");
        System.out.println("2) Add vehicle");
        System.out.println("3) Update vehicle price");
        System.out.println("4) Change vehicle status");
        System.out.println("5) Delete vehicle");

        System.out.println("6) Show clients");
        System.out.println("7) Add client");
        System.out.println("8) Update client age");
        System.out.println("9) Delete client");

        System.out.println("0) Exit");
        System.out.print("Choose: ");
    }

    private int readInt() {
        while (!sc.hasNextInt()) {
            sc.nextLine();
            System.out.print("Enter a number: ");
        }
        int x = sc.nextInt();
        sc.nextLine();
        return x;
    }

    private double readDouble() {
        while (!sc.hasNextDouble()) {
            sc.nextLine();
            System.out.print("Enter a number: ");
        }
        double x = sc.nextDouble();
        sc.nextLine();
        return x;
    }

    // -------- VEHICLES --------
    private void showVehicles() throws Exception {
        List<String> list = vehicleRepo.readAll(conn);
        if (list.isEmpty()) System.out.println("(no vehicles)");
        for (String v : list) System.out.println(v);
    }

    private void addVehicle() throws Exception {
        System.out.print("Model: ");
        String model = sc.nextLine();

        System.out.print("Price per day: ");
        double price = readDouble();

        vehicleRepo.create(conn, model, price, true);
        System.out.println("Vehicle added.");
    }

    private void updateVehiclePrice() throws Exception {
        System.out.print("Vehicle ID: ");
        int id = readInt();

        System.out.print("New price: ");
        double newPrice = readDouble();

        vehicleRepo.updatePrice(conn, id, newPrice);
        System.out.println("Vehicle price updated.");
    }

    private void updateVehicleStatus() throws Exception {
        System.out.print("Vehicle ID: ");
        int id = readInt();

        System.out.print("1 = Available, 2 = Rented: ");
        int st = readInt();

        boolean available = (st == 1);
        vehicleRepo.updateAvailability(conn, id, available);
        System.out.println("Vehicle status updated.");
    }

    private void deleteVehicle() throws Exception {
        System.out.print("Vehicle ID: ");
        int id = readInt();

        vehicleRepo.delete(conn, id);
        System.out.println("Vehicle deleted.");
    }

    // -------- CLIENTS --------
    private void showClients() throws Exception {
        List<String> list = clientRepo.readAll(conn);
        if (list.isEmpty()) System.out.println("(no clients)");
        for (String c : list) System.out.println(c);
    }

    private void addClient() throws Exception {
        System.out.print("Name: ");
        String name = sc.nextLine();

        System.out.print("Age: ");
        int age = readInt();

        clientRepo.create(conn, name, age);
        System.out.println("Client added.");
    }

    private void updateClientAge() throws Exception {
        System.out.print("Client ID: ");
        int id = readInt();

        System.out.print("New age: ");
        int age = readInt();

        clientRepo.updateAge(conn, id, age);
        System.out.println("Client age updated.");
    }

    private void deleteClient() throws Exception {
        System.out.print("Client ID: ");
        int id = readInt();

        clientRepo.delete(conn, id);
        System.out.println("Client deleted.");
    }
}
