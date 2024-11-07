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
}
