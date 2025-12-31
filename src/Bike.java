public class Bike extends Vehicle {

    private boolean electric;

    public Bike(String model, double price, boolean available, boolean electric) {
        super(model, price, available);
        this.electric = electric;
    }
    public boolean isElectric() {
        return electric;
    }
    public void setElectric(boolean electric) {
        this.electric = electric;
    }
}

