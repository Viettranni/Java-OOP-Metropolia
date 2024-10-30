public class CarDriver {
    public static void main(String[] args) {
        Car myCar;

        myCar = new Car("Toyota Corolla", 50.1, 180);
        myCar.fillTank();

        for (int i = 0; i < 6; i++) {
            myCar.accelerate();
            System.out.println(myCar.getTypeName() + ": speed is " + myCar.getSpeed());
        }

        while (myCar.getSpeed() > 0) {
            myCar.decelerate(15);
            System.out.println(myCar.getTypeName() + ": top speed is " + myCar.getTopSpeed() + "km/h and speed is " + myCar.getSpeed() + " km/h and the gas tank is: " + myCar.getGasolineCapacity());
        }
    }
}