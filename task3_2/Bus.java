package task3_2;

public class Bus extends Vehicle {
    private int passengerCapacity;

    public Bus(String type, String fuel, int passengerCapacity) {
        super(type, fuel);
        this.passengerCapacity = passengerCapacity;
    }

    public String getInfo() {
        System.out.println(this.getType() + " Information: ");
        return String.format("Type: %s, Fuel: %s, Capacity: %s", type, fuel, passengerCapacity);
    }

}
