package task3_2;

public class AbstractBus extends AbstractVehicle{
    private int capacity;
    private int batterylvl;

    public AbstractBus(String type, String fuel, int capacity) {
        super(type, fuel);
        this.capacity = capacity;
        this.batterylvl = 0;
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

    @Override
    public void charge(){
        if (this.fuel.equals("Electric")) {
            System.out.println("The Car is charging");
            batterylvl = 100;
        } else {
            System.out.println("The Car is not an electric, charging not possible!");
        }
    }

    @Override
    public int getBatteryLevel() {
        return batterylvl;
    }


}
