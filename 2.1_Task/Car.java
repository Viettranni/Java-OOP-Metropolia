
public class Car {
    /* An object of class Car will have instance variables speed and gasolineLevel.
     * Both are private (they can not be accessed outside the class methods).
     * Keep instance variables private whenever possible.
     */
    private double speed;
    private double gasolineLevel;
    private String typeName;
    private double gasolineCapacity;
    private int topSpeed;


    public Car(String typeName, double gasolineCapacity, int topSpeed) {
        speed = 0; gasolineLevel = 0;
        this.typeName = typeName;
        this.gasolineCapacity = gasolineCapacity;
        this.topSpeed = topSpeed;   
    }


    public void accelerate() {
        if (gasolineLevel > 0)
            speed += 10;
        else
            speed = 0;
    }
    void decelerate(int amount) {
        if (gasolineLevel > 0) {
            if (amount > 0)
                speed = Math.max(0, speed - amount);
        } else
            speed = 0;
    }
    double getSpeed() {
        return speed;
    }
    String getTypeName() {
        return typeName;
    }
    void fillTank() {
        gasolineLevel = 100;
    }
    double getGasolineLevel() {
        return gasolineLevel;
    }
    double getGasolineCapacity() {
        return gasolineCapacity;
    }
    int getTopSpeed() {
        return topSpeed;
    }
}

