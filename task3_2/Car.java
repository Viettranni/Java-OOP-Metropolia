package task3_2;

public class Car implements Vehicle {
    private String type;
    private String fuel;
    private String color;

    // Constructor
    public Car(String type, String fuel, String color) {
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

    @Override
    public void calculateFuelEfficiency() {
        if (this.fuel.equals("Electric")) {
            System.out.println("The vehicle's fuel efficiency is 0.15 kwh/km.");
        } else if (this.fuel.equals("Diesel")) {
            System.out.println("The vehicle's fuel efficiency is 0.07 l/km.");
        } else if (this.fuel.equals("Gasoline")) {
            System.out.println("The vehicle's fuel efficiency is 0.08 kwh/km.");
        } else {
            System.out.println("Please redefine the fuel type (Gasoline, Diesel, Electric)");
        }
    }
}
