package tasks3_1;

class SportsCar extends Car {
    public SportsCar(String typeName, double gasolineCapacity, int topSpeed) {
        super(typeName, gasolineCapacity, topSpeed);
    }

    @Override
    public void accelerate() {
        if (gasolineLevel > 0) {
            speed += 15;
            gasolineLevel -= 15;
        } else {
            speed = 0;
        }
    }

    @Override
    public void decelerate(int amount) {
        if (gasolineLevel > 0) {
            if (amount > 0)
                speed = Math.max(0, speed - amount);
        } else
            speed = 0;
    }
}
