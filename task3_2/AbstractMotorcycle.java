package task3_2;

public class AbstractMotorcycle extends AbstractVehicle{
    private int batterylvl; 

    public AbstractMotorcycle(String type, String fuel, String color) {
        super(type, fuel, color);
        this.batterylvl = 0;
    }

    @Override
    public void start() {
        System.out.println("Motorcycle is starting...");
    }

    @Override
    public void stop() {
        System.out.println("Motorcycle is stopping...");
    }

    @Override
    public String getInfo() {
        System.out.println(this.getType() + " Information: ");
        return String.format("Type: %s, Fuel: %s, Color: %s", type, fuel, color);
    }

    @Override
    public void charge(){
        if (this.fuel.equals("Electric")) {
            System.out.println("The motorcycle is charging");
            batterylvl = 100;
        } else {
            System.out.println("The motorcycle is not an electric vehicle, charging not possible!");
        }
    }

    @Override
    public int getBatteryLevel() {
        return batterylvl;
    }


}
