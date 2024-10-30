
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
    private boolean isOn = false;
    private double targetSpeed;


    public Car(String typeName, double gasolineCapacity, int topSpeed) {
        speed = 30; gasolineLevel = 0;
        this.typeName = typeName;
        this.gasolineCapacity = gasolineCapacity;
        this.topSpeed = topSpeed;   
    }

    public void cruiseControl(double setTargetSpeed) {
        if (setTargetSpeed <= 0 && setTargetSpeed >= 145) {
            System.out.println("The speed is currently not in the range of cruise control."); 
            return; 
        } else if (setTargetSpeed > topSpeed){
            System.out.println("The target speed is above the top speed of Vehicle.");
            return;
        };

        System.out.println("Cruise control set at " + setTargetSpeed + " kmh.");

        while (isOn && setTargetSpeed != speed ) {
            if (setTargetSpeed < speed){
                this.decelerate(10);
                System.out.println( "The speed is currently:" + speed ); 
            }
            if (setTargetSpeed > speed){
                this.accelerate();
                System.out.println( "The speed is currently:" + speed ); 
                
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Thread was interrupted, unable to sleep.");
            }

            if (speed == setTargetSpeed) {
                System.out.println("Cruise control is now set at " + setTargetSpeed + " km/h.");
                break; // Exit loop if speed matches target
            }
        }
    }

    public boolean turnOn(){
        System.out.println("Turning the cruise control on!");
        return isOn = true;
    }

    public void turnOff(){
        isOn = false;
        System.out.println("Cruise control is now OFF!");
    }

    public boolean getIsOn(){
        return isOn;
    }

    public double setTargetSpeed(double atargetSpeed){
        targetSpeed = atargetSpeed;
        return targetSpeed;
    }

    public double getTargetSpeed(){
        return targetSpeed;
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

