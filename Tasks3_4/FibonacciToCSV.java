package Tasks3_4;

import java.io.FileWriter;
import java.io.IOException;

public class FibonacciToCSV {

    public static void main(String[] args) {
        int n = 100;  // Number of Fibonacci numbers to generate and definition of the array length above
        long[] fibonacci = new long[n];
        // Initial First line
        fibonacci[0] = 0;
        // Initial Second line
        fibonacci[1] = 1;

        // Creating the next lines according to the n, it sums the 2 previous numbers
        for (int i = 2; i < n; i++) {
            fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
        }

        // Writing the numbers to the CSV file
        try (FileWriter writer = new FileWriter("fibonacci_sequence.csv")) {
            // Writing the header columns
            writer.append("Index,Fibonacci Number\n"); 
            
            // Writing the index and fibonacci values
            for (int i = 0; i < n; i++) {
                writer.append(i + 1 + "--> " + fibonacci[i] + "\n"); // Write index and number
            }

            System.out.println("Fibonacci sequence written to fibonacci_sequence.csv");

        } catch (IOException e) {
            System.out.println("An error occurred while writing to the CSV file.");
            e.printStackTrace();
        }
    }
}

