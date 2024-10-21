import java.util.Scanner;

public class HelloWorld {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Hello World! Would you mind giving me your name?");
        String Name = scanner.nextLine();

        System.out.println("Hello " + Name + ", welcome to our application!");

        scanner.close();
    }
}