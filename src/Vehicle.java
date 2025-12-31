public class Vehicle {

    private static int nextId = 1;
    private final int id;

    private String model;
    private double price;
    private boolean available;

    public Vehicle(String model, double price, boolean available) {
        this.id = nextId++;
        this.model = model;
        this.price = price;
        this.available = available;
    }

    public int getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public void printInfo() {
        String status;
        if (available) {
            status = "Available";
        } else {
            status = "Rented";
        }

        System.out.println("Vehicle -> ID: " + id +
                ", Model: " + model +
                ", Price: " + price +
                ", Status: " + status);
    }
    public String toString() {
        String status = available ? "Available" : "Rented";
        return "Vehicle { id=" + id +
                ", model='" + model + '\'' +
                ", price=" + price +
                ", status=" + status +
                " }";
    }
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vehicle)) return false;
        Vehicle vehicle = (Vehicle) o;
        return id == vehicle.id;
    }
    public int hashCode() {
        return Integer.hashCode(id);
    }
}


