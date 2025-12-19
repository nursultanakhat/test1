public class Main {

    public static void main(String[] args) {

        Vehicle car1 = new Vehicle("Toyota Camry", 50.0, false);
        Vehicle car2 = new Vehicle("BMW X5", 120.0, true);

        Client cl1 = new Client("Nursultan", 21);

        RentalService service = new RentalService();

        System.out.println("VEHICLES");
        car1.printInfo();
        car2.printInfo();

        System.out.println("\nCLIENT");
        cl1.printInfo();

        System.out.println("\nRENTAL PROCESS");
        service.rentVehicle(car2, cl1, 3);

        System.out.println("\nVEHICLES AFTER RENT");
        car1.printInfo();
        car2.printInfo();

    }
}

