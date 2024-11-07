package task3_2;

public class AbstractCar extends AbstractVehicle {
    public AbstractCar(String type, String fuel, String color) {
        super(type, fuel, color);
    }

    @Override
    public void start() {
        System.out.println("Car is starting...");
    }

    @Override
    public void stop() {
        System.out.println("Car is stopping...");
    }

    @Override
    public String getInfo() {
        System.out.println(this.getType() + " Information: ");
        return String.format("Type: %s, Fuel: %s, Color: %s", type, fuel, color);
    }
}
