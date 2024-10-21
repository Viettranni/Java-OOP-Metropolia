import java.util.Scanner;

public class Quadratic_Equation_Solver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Calculating roots using the quadratic formula! We would need you to prompt 3 coefficients of a quadratic equation. ");

        System.out.println("Enter for a");
        int a = scanner.nextInt();

        System.out.println("Enter for b");
        int b = scanner.nextInt();

        System.out.println("Enter for c");
        int c = scanner.nextInt();

        double discriminant = b * b - 4.0 * a * c;

        System.out.println("Discrimination: " + discriminant);

        if (discriminant < 0 ) {
            System.out.println("The equation is negative and therefore has no real roots. ");
        } else if (discriminant == 0) {
            System.out.println("The equation has one real root. ");
            oneRoot(a, b, c);
        } else if (discriminant > 0) {
            System.out.println("The equation has two real roots. ");
            twoRoots(a, b, c, discriminant);
        }

        scanner.close();
    }

    public static void twoRoots(int a, int b, int c, double discriminant) {
        double scenario1 = (-(b) + Math.sqrt(discriminant))/(2*a);
        double scenario2 = (-(b) - Math.sqrt(discriminant))/(2*a);

        System.out.printf("The first root is %.2f and the second root is %.2f", scenario1, scenario2);
    }

    public static void oneRoot(int a, int b, int c) {
        double root = -b / (2.0 * a);
        System.out.printf("The root is %.2f", root);
    }

}