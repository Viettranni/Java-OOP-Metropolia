package task3_2;

public class AbstractVehicleRun {
    public static void main(String[] args) {
        AbstractCar car = new AbstractCar("Car", "Diesel", "Grey");
        AbstractMotorcycle motorcycle = new AbstractMotorcycle("Motorcycle", "Petrol", "Red");
        AbstractBus bus = new AbstractBus("Bus", "Diesel", 40);

        car.start();
        car.stop();
        System.out.println(car.getInfo());

        motorcycle.start();
        motorcycle.stop();
        System.out.println(motorcycle.getInfo());

        bus.start();
        bus.stop();
        System.out.println(bus.getInfo());
    }
}
