import java.util.Scanner;

public class Name_Generator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] firstNames = {"Viet", "Saed", "Pekka", "Trung", "Matti"};
        String[] lastNames = {"Tran", "Abukar", "Le", "Mattinen", "Nguyen"};

        System.out.println("How many random names would you like to generate?");
        int randomNameAmount = scanner.nextInt();

        for ( int i = 0; i < randomNameAmount; i++) {
            String randomFirstName = firstNames[(int) (Math.random() * firstNames.length)];
            String randomLastName = lastNames[(int) (Math.random() * firstNames.length)];
            String completeName = randomFirstName + " " + randomLastName;
            System.out.println(completeName);
        }

        scanner.close();
    }
}
