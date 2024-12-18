package tasks3_1;

public class CarDriver {
    public static void main(String[] args) {
        Car myCar;
        SportsCar sporttis;
        Bus myBus;

        // Ordinary Car
        myCar = new Car("Toyota Corolla", 50.1, 180);
        myCar.fillTank();

        // Sport Car
        sporttis = new SportsCar("Batman", 80.4, 250);
        sporttis.fillTank();

        // Bus
        myBus = new Bus("School bus", 120.3, 80, 12); 
        myBus.fillTank();

        // Comparing the acceleration and fuel consumption of both cars
        myCar.accelerate();
        System.out.println("Speed of the current car: " + myCar.getSpeed());
        System.out.println("The ordinary car gas tank is left at " + myCar.getGasolineLevel());


        sporttis.accelerate();
        System.out.println("Speed of the current car: " + sporttis.getSpeed());
        System.out.println("The sports car gas tank is left at: " + sporttis.getGasolineLevel());

        
        myBus.passengerEnter();
        myBus.passengerEnter();
        myBus.passengerExit();

    }
}
