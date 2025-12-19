public class Vehicle {
    private String model;
    private double price;
    private boolean available;
    public Vehicle(String model, double price, boolean available) {
        this.model = model;
        this.price = price;
        this.available = available;
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
            status = "true";
        } else {
            status = "false";
        }
        System.out.println("Vehicle -> Model: " + model +
                ", Price: " + price +
                ", Status: " + status);
    }

}

