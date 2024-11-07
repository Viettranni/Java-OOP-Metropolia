package task3_2;

public class VehicleRun {
    public static void main(String[] args) {
        Car car = new Car("Car", "Diesel", "Grey");
        Motorcycle motorcycle = new Motorcycle("Motorcycle", "Petrol", "Red");
        Bus bus = new Bus("Bus", "Diesel", 40);

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

