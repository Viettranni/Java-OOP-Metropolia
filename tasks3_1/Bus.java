package tasks3_1;

public class Bus extends Car {
    private int passengerAmount;
    private int currentPassengersOnBoard;

    public Bus(String typeName, double gasolineCapacity, int topSpeed, int passengerAmount){
        super(typeName, gasolineCapacity, topSpeed);
        this.passengerAmount = passengerAmount;
    }

    public void passengerEnter() {
        if (gasolineLevel > 0) {

        }
        if (currentPassengersOnBoard < passengerAmount) {
            currentPassengersOnBoard += 1;
            System.out.println("Welcome on the bus! :) Have a nice ride. ");
        } else {
            System.out.println("The bus is full! Take the next Bus.");
        }
    }

    public void passengerExit() {
        if (currentPassengersOnBoard > currentPassengersOnBoard) {
            System.out.println("There is no one on the bus to exit.");
        } else {
            currentPassengersOnBoard -= 1;
            System.out.println("Thank you for riding with us! There is currently " + currentPassengersOnBoard + " passengers on the bus.");
        }
    }
}
