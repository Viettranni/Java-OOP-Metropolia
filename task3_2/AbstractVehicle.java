package task3_2;

public abstract class AbstractVehicle {
    protected String type;
    protected String fuel;
    protected String color;

    public AbstractVehicle(String type, String fuel, String color) {
        this.type = type;
        this.fuel = fuel;
        this.color = color;
    }

    public AbstractVehicle(String type, String fuel) {
        this.type = type;
        this.fuel = fuel;
    }

    public String getType() {
        return type;
    }

    public abstract void start();

    public abstract void stop();

    public abstract String getInfo();
}
