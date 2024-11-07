package task3_2;

public class Vehicle {
    protected String type;
    protected String fuel;
    protected String color;

    public Vehicle(String type, String fuel, String color) {
        this.type = type;
        this.fuel = fuel;
        this.color = color;
    }

    public void start() {
        System.out.println("Vehicle starting..");
    }

    public void stop() {
        System.out.println("Vehicle is stopping..");
    }

    public String getInfo() {
        return String.format("Type: %s, Fuel: %s, Color: %s", type, fuel, color);
    }
}
