package task3_2;

public class Motorcycle implements Vehicle {
    private String type;
    private String fuel;
    private String color;

    // Constructor
    public Motorcycle(String type, String fuel, String color) {
        this.type = type;
        this.fuel = fuel;
        this.color = color;
    }

    // Implementing the getType method
    @Override
    public String getType() {
        return type;
    }

    // Implementing the start method
    @Override
    public void start() {
        System.out.println(this.getType() + " is starting...");
    }

    // Implementing the stop method
    @Override
    public void stop() {
        System.out.println(this.getType() + " is stopping...");
    }

    // Implementing the getInfo method
    @Override
    public String getInfo() {
        System.out.println(this.getType() + " Information: ");
        return String.format("Type: %s, Fuel: %s, Color: %s", type, fuel, color);
    }
}
