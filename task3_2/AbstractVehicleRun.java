package task3_2;

public class AbstractVehicleRun {
    public static void main(String[] args) {
        AbstractCar car = new AbstractCar("Car", "Electric", "Grey");
        AbstractMotorcycle motorcycle = new AbstractMotorcycle("Motorcycle", "Electric", "Red");
        AbstractBus bus = new AbstractBus("Bus", "Diesel", 40);

        car.charge();
        car.start();
        car.stop();
        System.out.println(car.getInfo());

        motorcycle.charge();
        motorcycle.start();
        motorcycle.stop();
        System.out.println(motorcycle.getInfo());

        bus.start();
        bus.stop();
        System.out.println(bus.getInfo());
    }
}
