import java.util.Scanner;


public class Triangles {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("I will help you calculate the  hypotenuse of the triangle but I would need you to provide 2 of the legs.");

        System.out.println("Please provide the first Leg: ");
        double firstLeg = scanner.nextDouble();

        System.out.println("Please provide the second Leg: ");
        double secondLeg = scanner.nextDouble();

        double hypotenuse = Math.sqrt(firstLeg * firstLeg + secondLeg * secondLeg);

        System.out.println("The hypotenuse of the triangle is " + hypotenuse);
    }
}
