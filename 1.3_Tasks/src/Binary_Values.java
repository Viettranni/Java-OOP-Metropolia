import java.util.Scanner;

public class Binary_Values {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please provide the binary for conversion:");
        String binary = scanner.nextLine();

        int decimal = 0;

        for (int i = 0; i < binary.length(); i++) {
            // Using the charAt to get the bit
            char bit = binary.charAt(binary.length() - i - 1);
            // Add the bit to decimal by first converting it to number
            decimal += Character.getNumericValue(bit) * Math.pow(2, i);
        }

        System.out.println("The given binari is " + binary + " and the decimal of it is: " + decimal);

    }
}
