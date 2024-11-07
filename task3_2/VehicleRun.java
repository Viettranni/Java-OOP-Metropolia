package task3_2;

public class VehicleRun {
    public static void main(String[] args) {
        Car car = new Car("Car", "Diesel", "Grey");
        Motorcycle motorcycle = new Motorcycle("Motorcycle", "Gasoline", "Red");
        Bus bus = new Bus("Bus", "Electric", 40);

        car.start();
        car.stop();
        car.calculateFuelEfficiency();
        System.out.println(car.getInfo());

        motorcycle.start();
        motorcycle.stop();
        motorcycle.calculateFuelEfficiency();
        System.out.println(motorcycle.getInfo());

        bus.start();
        bus.stop();
        bus.calculateFuelEfficiency();
        System.out.println(bus.getInfo());
    }
}

