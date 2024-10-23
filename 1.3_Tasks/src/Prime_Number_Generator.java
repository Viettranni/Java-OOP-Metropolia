import java.util.Scanner;


public class Prime_Number_Generator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("I would need two positive numbers for prime checking.");

        System.out.println("Please provide the first positive number: ");
        int firstNumber = scanner.nextInt();

        System.out.println("Please provide the second positive number: ");
        int secondNumber = scanner.nextInt();

        for ( int i = firstNumber; i <= secondNumber; i++) {
            if (isPrime(i)) {
                System.out.println(i);
            }
        }
    }

    // Method for checking if the number is Prime
    public static boolean isPrime(int number) {
        if (number < 2) {
            return false; // Numbers less than 2 are not prime
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false; // If divisible by any number, it's not prime
            }
        }
        return true; // The number is prime
    }
}
