
public class CoffeeMaker {
    private String coffeeType;
    private int coffeeAmount;
    private boolean isOn = false;
    private boolean hasWater;


    public CoffeeMaker(String coffeeType, int coffeeAmount, boolean isOn){
        hasWater = true;
        this.coffeeType = coffeeType;
        this.coffeeAmount = coffeeAmount;
        this.isOn = isOn; 
    }


    public void setIsOn(Boolean a) {
        isOn = a;
    }

    public String setCoffeeType(String type) {
        if (type.equalsIgnoreCase("espresso") || type.equalsIgnoreCase("normal")) {
            coffeeType = type.toLowerCase(); // Store the coffeeType in lowercase
        } else {
            System.out.println("Invalid coffee type. Defaulting to normal.");
            coffeeType = "normal"; 
        }
        return coffeeType;
    }

    public int setCoffeeAmount(int amount) {
        return coffeeAmount = amount;
    }

    public boolean getIsOn() {
        return isOn;
    }

    public boolean getHasWater() {
        return hasWater;
    }

    public int getCoffeeAmount() {
        return coffeeAmount;
    }

    public String getCoffeeType() {
        return coffeeType;
    }

}
