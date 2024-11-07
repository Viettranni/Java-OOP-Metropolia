package task3_2;

public class AbstractCar extends AbstractVehicle {
    private int batterylvl;

    public AbstractCar(String type, String fuel, String color) {
        super(type, fuel, color);
        this.batterylvl = 0;
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
