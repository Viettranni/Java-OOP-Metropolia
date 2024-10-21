import java.util.Scanner;

public class Obsolete_Measures {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double luoti_initial = 13.28;
        double naula_initial = luoti_initial * 32;
        double leiviska_initial = naula_initial * 20;

        System.out.println("Please provide the amount in grams: ");
        double weight  = scanner.nextDouble();

        // Leiviska calculations
        double leiviska = weight/leiviska_initial;
        int leiviska_int = (int) Math.floor(leiviska);
        double fractionalLeiviska = leiviska - leiviska_int;
        double convert_to_grams_leiviska = fractionalLeiviska * leiviska_initial;

        // Naula calculations
        double naula = convert_to_grams_leiviska / naula_initial;
        int naula_int = (int) Math.floor(naula);
        double fractionalNaula = naula - naula_int;
        double convert_to_grams_naula = fractionalNaula * naula_initial;

        // Luoti calculations
        double luoti = convert_to_grams_naula / luoti_initial;

        System.out.printf("Leiviska: %d Naula: %d Luoti: %.2f%n", leiviska_int, naula_int, luoti);
    }
}
