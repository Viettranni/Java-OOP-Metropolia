import java.util.Scanner;

public class CoffeeMakerDriver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CoffeeMaker MyCoffeeMaker;

        MyCoffeeMaker = new CoffeeMaker("normal", 20, true);

        while (MyCoffeeMaker.getHasWater()) {

            MyCoffeeMaker.setIsOn(true);

            System.out.print("Would you like to pour the coffee with the previous settings (yes/no)? ");
            String previousSettings = scanner.nextLine();

            if (MyCoffeeMaker.getIsOn() && previousSettings.equals("no")) {
                
                System.out.println("Coffee maker is on!");

                System.out.println("Would you like to have an espresso or normal coffee? ");
                String coffeeType = scanner.nextLine();
                MyCoffeeMaker.setCoffeeType(coffeeType);
                String getCoffeeType = MyCoffeeMaker.getCoffeeType();
                System.out.println("Coffee type is: " + getCoffeeType);

                System.out.println("How much of coffee would you like to have? (10ml-80ml) ");
                int coffeeAmount = scanner.nextInt();
                scanner.nextLine();
                MyCoffeeMaker.setCoffeeAmount(coffeeAmount);

                if (coffeeAmount < 10 || coffeeAmount > 80) {
                    System.out.println("Please re-enter the right amount! (10ml-80ml)");
                    int rightAmount = scanner.nextInt();
                    scanner.nextLine();
                    MyCoffeeMaker.setCoffeeAmount(rightAmount);
                } else {
                    int getcoffeeAmount = MyCoffeeMaker.getCoffeeAmount();
                    System.out.println("Coffee amount is: " + getcoffeeAmount);
                }

                MyCoffeeMaker.setIsOn(false);
                System.out.println("Coffee maker is off!");
            }
            else if (MyCoffeeMaker.getIsOn() && previousSettings.equals("yes")) {
                System.out.println("Coffee maker is on!");
                System.out.println("Coffee type is:" + MyCoffeeMaker.getCoffeeType());
                System.out.println("Coffee amount is: " + MyCoffeeMaker.getCoffeeAmount());
                MyCoffeeMaker.setIsOn(false);
                System.out.println("Coffee maker is off!");
            }
        }
        scanner.close();
    }
}
