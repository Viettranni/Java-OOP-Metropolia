import java.util.Scanner;

public class Temperature_Converter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Give me the Fahrenheit for Conversion: ");
        double fahrenheit = scanner.nextDouble();

        double converted_temperature = 5.0/9.0*(fahrenheit-32);
        System.out.printf("The Fahrenheit %.1f in Celsius is: %.1f°C\n", fahrenheit, converted_temperature);
    }
}
