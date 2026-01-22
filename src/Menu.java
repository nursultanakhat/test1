import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private final Scanner sc = new Scanner(System.in);
    private final Connection conn;

    private final VehicleDAO vehicleDAO = new VehicleDAO();
    private final ClientDAO clientDAO = new ClientDAO();

    public Menu(Connection conn) {
        this.conn = conn;
    }

    public void start() {
        while (true) {
            showMenu();
            int choice = readInt();

            try {
                switch (choice) {
                    // Vehicle CRUD
                    case 1 -> showVehicles();
                    case 2 -> addVehicle();
                    case 3 -> updateVehiclePrice();
                    case 4 -> updateVehicleStatus();
                    case 5 -> deleteVehicle();

                    // Client CRUD
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
        System.out.println("\n=== VEHICLE RENTAL ===");
        System.out.println("1) Show vehicles");
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

    // --- Vehicle actions ---
    private void showVehicles() throws Exception {
        List<String> list = vehicleDAO.readAll(conn);
        if (list.isEmpty()) System.out.println("(no vehicles)");
        for (String s : list) System.out.println(s);
    }

    private void addVehicle() throws Exception {
        System.out.print("Model: ");
        String model = sc.nextLine();

        System.out.print("Price per day: ");
        double price = readDouble();

        vehicleDAO.create(conn, model, price, true);
        System.out.println("Vehicle added.");
    }

    private void updateVehiclePrice() throws Exception {
        System.out.print("Vehicle ID: ");
        int id = readInt();

        System.out.print("New price: ");
        double newPrice = readDouble();

        vehicleDAO.updatePrice(conn, id, newPrice);
        System.out.println("Vehicle price updated.");
    }

    private void updateVehicleStatus() throws Exception {
        System.out.print("Vehicle ID: ");
        int id = readInt();

        System.out.print("1 = Available, 2 = Rented: ");
        int st = readInt();

        boolean available = (st == 1);
        vehicleDAO.updateAvailability(conn, id, available);
        System.out.println("Vehicle status updated.");
    }

    private void deleteVehicle() throws Exception {
        System.out.print("Vehicle ID: ");
        int id = readInt();

        vehicleDAO.delete(conn, id);
        System.out.println("Vehicle deleted.");
    }

    // --- Client actions ---
    private void showClients() throws Exception {
        List<String> list = clientDAO.readAll(conn);
        if (list.isEmpty()) System.out.println("(no clients)");
        for (String s : list) System.out.println(s);
    }

    private void addClient() throws Exception {
        System.out.print("Name: ");
        String name = sc.nextLine();

        System.out.print("Age: ");
        int age = readInt();

        clientDAO.create(conn, name, age);
        System.out.println("Client added.");
    }

    private void updateClientAge() throws Exception {
        System.out.print("Client ID: ");
        int id = readInt();

        System.out.print("New age: ");
        int age = readInt();

        clientDAO.updateAge(conn, id, age);
        System.out.println("Client age updated.");
    }

    private void deleteClient() throws Exception {
        System.out.print("Client ID: ");
        int id = readInt();

        clientDAO.delete(conn, id);
        System.out.println("Client deleted.");
    }
}

