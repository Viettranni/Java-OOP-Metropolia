package task3_2;

public class Bus implements Vehicle {
    private String type;
    private String fuel;
    private int passengerCapacity;

    // Constructor
    public Bus(String type, String fuel, int passengerCapacity) {
        this.type = type;
        this.fuel = fuel;
        this.passengerCapacity = passengerCapacity;
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
        return String.format("Type: %s, Fuel: %s, Capacity: %d", type, fuel, passengerCapacity);
    }

    @Override
    public void calculateFuelEfficiency() {
        if (this.fuel.equals("Electric")) {
            System.out.println("The vehicle's fuel efficiency is 1.5 kwh/km.");
        } else if (this.fuel.equals("Diesel")) {
            System.out.println("The vehicle's fuel efficiency is 0.20 l/km.");
        } else if (this.fuel.equals("Gasoline")) {
            System.out.println("The vehicle's fuel efficiency is 0.23 kwh/km.");
        } else {
            System.out.println("Please redefine the fuel type (Gasoline, Diesel, Electric)");
        }
    }
}
