public class CarDriver {
    public static void main(String[] args) {
        Car myCar;

        myCar = new Car("Toyota Corolla", 50.1, 180);
        myCar.fillTank();

        // Setting cruise control
        myCar.setTargetSpeed(90);
        
        // Turning cruise control ON
        myCar.turnOn();
        myCar.cruiseControl(90);
        myCar.cruiseControl(50);
        myCar.cruiseControl(80);
        myCar.turnOff();

    }
}