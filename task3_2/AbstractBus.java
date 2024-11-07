package task3_2;

public class AbstractBus extends AbstractVehicle{
    private int capacity;

    public AbstractBus(String type, String fuel, int capacity) {
        super(type, fuel);
        this.capacity = capacity;
    }

    @Override
    public void start() {
        System.out.println("Bus is starting...");
    }

    @Override
    public void stop() {
        System.out.println("Bus is stopping...");
    }

    @Override
    public String getInfo() {
        System.out.println(this.getType() + " Information: ");
        return String.format("Type: %s, Fuel: %s, Capacity: %s", type, fuel, capacity);
    }


}
