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

    public Vehicle(String type, String fuel) {
        this.type = type;
        this.fuel = fuel;
    }

    public String getType() {
        return type;
    }

    public void start() {
        System.out.println(this.getType() + " starting..");
    }

    public void stop() {
        System.out.println(this.getType() + " starting..");
    }

    public String getInfo() {
        System.out.println(this.getType() + " Information: ");
        return String.format("Type: %s, Fuel: %s, Color: %s", type, fuel, color);
    }
}
