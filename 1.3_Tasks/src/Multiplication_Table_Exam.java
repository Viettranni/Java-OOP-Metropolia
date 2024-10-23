import java.util.Scanner;
import java.util.Random;

public class Multiplication_Table_Exam {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        Random random = new Random();

        System.out.println("You will be assigned 13 questions and you have to answer correctly atleast to 10 questions in order to pass the test!");
        int totalPoints = 0;

        while (totalPoints < 13) {
            for (int i = 1; i <= 13; i++) {
                int randomNumber1 = random.nextInt(11);
                int randomNumber2 = random.nextInt(11);
                int correctAnswer = randomNumber1 * randomNumber2;

                System.out.println("Please multiply the number " + randomNumber1 + " with " + randomNumber2 + ": ");
                int studentAnswer = scanner.nextInt();

                // If the answer is correct you can
                if (studentAnswer == correctAnswer) {
                    totalPoints++;
                }
            }
            // Checking if the student has reached the total points of 10
            if (totalPoints < 10) {
                System.out.println("You didn't pass the test, retake it please!");
            } else {
                System.out.println("You passed the TEST! Congratulations!");
                break;
            }
        }
    }

}
