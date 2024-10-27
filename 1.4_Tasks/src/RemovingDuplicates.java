import java.util.Scanner;

public class RemovingDuplicates {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please provide the size of the array!");
        int size = scanner.nextInt();
        int[] array = new int[size];

        for (int i = 0; i < size; i++){
            System.out.println("Provide the " + (i+1) + ". number of the array:");
            array[i] = scanner.nextInt();
        }

        int[] uniqueArray = new int[size];
        int uniqueIndex = 0;

        // Filtering the duplicates
        for (int i = 0; i < size; i++) {
            boolean isDuplicate = false;
            
            // Check if current element is already in uniqueArray
            for (int j = 0; j < uniqueIndex; j++) {
                if (array[i] == uniqueArray[j]) {
                    isDuplicate = true;
                    break;
                }
            }

            // If not a duplicate, add it to uniqueArray
            if (!isDuplicate) {
                uniqueArray[uniqueIndex++] = array[i];
            }
        }

        // Print the array without duplicates
        System.out.println("\nThe array without duplicates:");
        for (int i = 0; i < uniqueIndex; i++) {
            System.out.print(uniqueArray[i] + " ");
        }
        

        scanner.close();
    }
}
