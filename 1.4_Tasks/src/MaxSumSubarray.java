import java.util.Scanner;

public class MaxSumSubarray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();
        int[] array = new int[size];

        System.out.println("Enter the integers into the array:");
        for (int i = 0; i < size; i++) {
            System.out.print("Enter integer " + (i + 1) + ": ");
            array[i] = scanner.nextInt();
        }

        int maxSum = Integer.MIN_VALUE; 
        int start = 0, end = 0;     

        for (int i = 0; i < size; i++) {
            int currentSum = 0;
            for (int j = i; j < size; j++) {
                currentSum += array[j];
                
                if (currentSum > maxSum) {
                    maxSum = currentSum;
                    start = i + 1; 
                    end = j + 1;   
                }
            }
        }
        
        System.out.println("Maximum sum: " + maxSum);
        System.out.println("Integers: " + start + "-" + end);

        scanner.close();
    }
}
